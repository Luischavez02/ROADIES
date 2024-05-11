@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.roadieapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class RoadieScreen(@androidx.annotation.StringRes val title: Int){
    Home(title = R.string.app_name),
    RoadieHomeScreen(title = R.string.roadie_home_screen),
    RoadieAutomationScreen(title = R.string.roadie_automation_screen),
    RoadieManualScreen(title = R.string.roadie_manual_screen),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoadieAppTopBar(
    currentScreen: RoadieScreen,
    modifier: Modifier = Modifier,
){
    TopAppBar(title = { Text(stringResource(currentScreen.title))},
        colors = mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {}
    )
}

@Composable
fun RoadieApplication(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
){
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = RoadieScreen.valueOf(
        backStackEntry?.destination?.route ?: RoadieScreen.RoadieHomeScreen.name
    )
    Scaffold(
        topBar = {
            RoadieAppTopBar(currentScreen = currentScreen)
        },
        modifier = modifier,
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = RoadieScreen.RoadieHomeScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = RoadieScreen.RoadieHomeScreen.name) {
                RodieHomeScreen(
                    modifier = Modifier.padding(16.dp),
                    onClickAutomationScreen = {
                        navController.navigate(RoadieScreen.RoadieAutomationScreen.name)
                    },
                    onClickManualScreen = {
                        navController.navigate(RoadieScreen.RoadieManualScreen.name)
                    }
                )
            }
            composable(route = RoadieScreen.RoadieAutomationScreen.name) {
                RoadieAutomationScreen(
                    modifier = Modifier.padding(16.dp)
                )
            }
            composable(route = RoadieScreen.RoadieManualScreen.name) {
                RoadieManualScreen(
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
    //RoadieAppTopBar(currentScreen = RoadieScreen.Home, modifier = modifier)
}


