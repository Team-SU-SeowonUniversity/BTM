package com.teamsu.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.teamsu.presentation.main.zone.gamezone.analysis.AnalysisScreen
import com.teamsu.presentation.main.zone.gamezone.calculation.CalculationScreen
import com.teamsu.presentation.main.zone.gamezone.instinctive.InstinctiveScreen
import com.teamsu.presentation.main.zone.gamezone.memory.MemoryScreen
import com.teamsu.presentation.main.zone.gamezone.perception.PerceptionScreen
import com.teamsu.presentation.main.zone.components.CountDownViewModel
import com.teamsu.presentation.main.zone.gamezone.perception.game.shadowmatching.ShadowMatching
import com.teamsu.presentation.main.zone.gamezone.perception.game.shadowmatching.ShadowMatchingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                composable(route = MainNavigation.SHADOW_MATCHING.route) {
                    ShadowMatching(
                        navController = navController,
                        countDownViewModel = viewModel<CountDownViewModel>(),
                        shadowMatchingViewModel = viewModel<ShadowMatchingViewModel>()
                    )
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
