package com.teamsu.presentation.start

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.teamsu.presentation.main.MainActivity
import com.teamsu.presentation.ui.theme.BrainTrainingMorningTheme

class StartActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrainTrainingMorningTheme {
                val navController = rememberNavController()
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setStatusBarColor(color = Color.Black)
                }

                NavHost(
                    navController = navController,
                    startDestination = StartNavigation.START_LOGIN.route
                ) {
                    composable(route = StartNavigation.START_LOGIN.route) {
                        StartScreen()
                    }
                }
            }
        }
    }

    fun startMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}