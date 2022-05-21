package com.teamsu.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.GameZoneScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            val navController = rememberNavController()

            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.Black
                )
            }

            val buttonText = listOf(
                stringResource(id = R.string.perception),
                stringResource(id = R.string.memory),
                stringResource(id = R.string.instinctive),
                stringResource(id = R.string.calculation),
                stringResource(id = R.string.analysis),
                stringResource(id = R.string.state),
            )

            NavHost(
                navController = navController,
                startDestination = MainNavigation.MAIN.route
            ) {
                composable(route = MainNavigation.MAIN.route) {
                    MainScreen(navController = navController, buttonText = buttonText)
                }
                composable(route = MainNavigation.PERCEPTION.route) {
                    GameZoneScreen(zoneName = buttonText[0], navController = navController)
                }
                composable(route = MainNavigation.MEMORY.route) {
                    GameZoneScreen(zoneName = buttonText[1], navController = navController)
                }
                composable(route = MainNavigation.INSTINCTIVE.route) {
                    GameZoneScreen(zoneName = buttonText[2], navController = navController)
                }
                composable(route = MainNavigation.CALCULATION.route) {
                    GameZoneScreen(zoneName = buttonText[3], navController = navController)
                }
                composable(route = MainNavigation.ANALYSIS.route) {
                    GameZoneScreen(zoneName = buttonText[4], navController = navController)
                }
                composable(route = MainNavigation.STATE.route) {
                }
            }
        }
    }
}
