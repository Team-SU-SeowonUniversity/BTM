package com.teamsu.presentation.main.zone.gamezone.analysis

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.GameZone

@Composable
internal fun AnalysisScreen(
    navController: NavController
) {
    val gameName = listOf<String>()
    val gameThumbnail = listOf<Painter>()
    val route = listOf<String>()

    GameZone(
        zoneName = stringResource(id = R.string.analysis),
        navController = navController,
        gameName = gameName,
        gameThumbnail = gameThumbnail,
        route = route
    )
}