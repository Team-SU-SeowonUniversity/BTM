package com.teamsu.presentation.main.zone.calculation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.GameZone

@Composable
internal fun CalculationScreen(
    navController: NavController
) {
    val gameName = listOf(stringResource(id = R.string.adjusting_the_Amount_of_Water))
    val gameThumbnail = listOf(painterResource(id = R.drawable.back))

    GameZone(
        zoneName = stringResource(id = R.string.calculation),
        navController = navController,
        gameName = gameName,
        gameThumbnail = gameThumbnail
    )
}