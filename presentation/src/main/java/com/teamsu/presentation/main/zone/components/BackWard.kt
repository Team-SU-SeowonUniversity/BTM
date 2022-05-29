package com.teamsu.presentation.main.zone.components

import androidx.compose.foundation.Image
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.teamsu.presentation.R

@Composable
internal fun BackWard(navController: NavController) {
    IconButton(
        onClick = { navController.popBackStack() }
    ) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = "go to main"
        )
    }
}