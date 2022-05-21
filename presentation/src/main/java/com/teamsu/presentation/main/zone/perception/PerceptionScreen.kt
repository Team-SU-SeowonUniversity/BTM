package com.teamsu.presentation.main.zone.perception

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.GameZone

@Composable
internal fun PerceptionScreen(
    navController: NavController
) {
    val gameName = listOf(stringResource(id = R.string.shadow_matching))
    val gameThumbnail = listOf(painterResource(id = R.drawable.back))

    GameZone(
        zoneName = stringResource(id = R.string.perception),
        navController = navController,
        gameName = gameName,
        gameThumbnail = gameThumbnail
    )
}