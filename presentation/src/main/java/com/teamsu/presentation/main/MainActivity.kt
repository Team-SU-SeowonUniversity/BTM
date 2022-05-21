package com.teamsu.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.teamsu.presentation.main.zone.analysis.AnalysisScreen
import com.teamsu.presentation.main.zone.calculation.CalculationScreen
import com.teamsu.presentation.main.zone.instinctive.InstinctiveScreen
import com.teamsu.presentation.main.zone.memory.MemoryScreen
import com.teamsu.presentation.main.zone.perception.PerceptionScreen

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

            NavHost(
                navController = navController,
                startDestination = MainNavigation.MAIN.route
            ) {
                composable(route = MainNavigation.MAIN.route) {
                    MainScreen(navController = navController)
                }
                composable(route = MainNavigation.PERCEPTION.route) {
                    PerceptionScreen(navController = navController)
                }
                composable(route = MainNavigation.MEMORY.route) {
                    MemoryScreen(navController = navController)
                }
                composable(route = MainNavigation.INSTINCTIVE.route) {
                    InstinctiveScreen(navController = navController)
                }
                composable(route = MainNavigation.CALCULATION.route) {
                    CalculationScreen(navController = navController)
                }
                composable(route = MainNavigation.ANALYSIS.route) {
                    AnalysisScreen(navController = navController)
                }
                composable(route = MainNavigation.STATE.route) {
                }
            }
        }
    }
}
