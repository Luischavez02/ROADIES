package com.example.roadieapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RoadieManualScreen(
    modifier: Modifier = Modifier,
    onClickAutomationScreen: () -> Unit = {},
    onClickManualScreen: () -> Unit = {},
){
    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Actuator:",
            modifier = modifier
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
            ) {
            OutlinedButton(
                onClick = { onClickManualScreen() },
                modifier = modifier
            ) {
                Text(
                    text = "UP",
                    modifier = modifier
                )
            }
            OutlinedButton(
                onClick = { onClickManualScreen() },
                modifier = modifier
            ) {
                Text(
                    text = "DOWN",
                    modifier = modifier
                )
            }
        }
        Text(
                text = "Control:",
                modifier = modifier
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { onClickManualScreen() },
                modifier = modifier
            ) {
                Text(
                    text = "FWD",
                    modifier = modifier
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { onClickManualScreen() },
                modifier = modifier
            ) {
                Text(
                    text = "LEFT",
                    modifier = modifier
                )
            }
            OutlinedButton(
                onClick = { onClickManualScreen() },
                modifier = modifier
            ) {
                Text(
                    text = "RIGHT",
                    modifier = modifier
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            OutlinedButton(
                onClick = { onClickManualScreen() },
                modifier = modifier
            ) {
                Text(
                    text = "BWD",
                    modifier = modifier
                )
            }
        }
    }
}

