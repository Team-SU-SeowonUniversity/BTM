package com.teamsu.presentation.main.zone.gamezone.memory

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.GameZone

@Composable
internal fun MemoryScreen(
    navController: NavController
) {
    val gameName = listOf(stringResource(id = R.string.aligning_the_lights)) // 도메인, 서버에 넣을 부분
    val gameThumbnail = listOf(painterResource(id = R.drawable.back)) // 도메인, 서버에 넣을 부분

    /*GameZone(
        zoneName = stringResource(id = R.string.memory),
        navController = navController,
        gameName = gameName,
        gameThumbnail = gameThumbnail
    )*/
}