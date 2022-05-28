package com.teamsu.presentation.main.zone.gamezone.instinctive

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.GameZone

@Composable
internal fun InstinctiveScreen(
    navController: NavController
) {
    val gameName = listOf(stringResource(id = R.string.capturing_the_moment))
    val gameThumbnail = listOf(painterResource(id = R.drawable.back))

    /*GameZone(
        zoneName = stringResource(id = R.string.memory),
        navController = navController,
        gameName = gameName,
        gameThumbnail = gameThumbnail
    )*/
}