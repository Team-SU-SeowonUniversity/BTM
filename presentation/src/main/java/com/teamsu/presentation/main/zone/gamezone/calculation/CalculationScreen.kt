package com.teamsu.presentation.main.zone.gamezone.calculation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.GameZone

@Composable
internal fun CalculationScreen(
    navController: NavController
) {
    val gameName = listOf<String>()
    val gameThumbnail = listOf<Painter>()
    val route = listOf<String>()

    GameZone(
        zoneName = stringResource(id = R.string.calculation),
        navController = navController,
        gameName = gameName,
        gameThumbnail = gameThumbnail,
        route = route
    )
}