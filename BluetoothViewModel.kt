package com.example.roadieapplication

import android.Manifest
import android.app.Application
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothSocket
import android.content.Intent
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.io.OutputStream
import java.util.*

class BluetoothViewModel(application: Application) : AndroidViewModel(application) {

    var bluetoothSocket: BluetoothSocket? = null
    lateinit var outputStream: OutputStream

    fun connectToBluetoothDevice() {
        val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
        if (bluetoothAdapter == null) {
            // Bluetooth not supported
            return
        }
        if (!bluetoothAdapter.isEnabled) {
            // Bluetooth is not enabled, request to turn it on
            return
        }

        // Request permission if not granted
        if (ActivityCompat.checkSelfPermission(
                getApplication(),
                Manifest.permission.BLUETOOTH_CONNECT
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // TODO: Handle permission request
            return
        }

        val pairedDevices: Set<BluetoothDevice>? = bluetoothAdapter.bondedDevices
        if (pairedDevices != null) {
            for (device in pairedDevices) {
                if (device.name == "Roadie") {
                    val uuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB") // Standard SPP UUID
                    bluetoothSocket = device.createInsecureRfcommSocketToServiceRecord(uuid)
                    bluetoothSocket?.connect()
                    outputStream = bluetoothSocket!!.outputStream
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        try {
            bluetoothSocket?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
