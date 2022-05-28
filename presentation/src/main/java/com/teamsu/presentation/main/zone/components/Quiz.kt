package com.teamsu.presentation.main.zone.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.ui.theme.songMyung

@Composable
fun Quiz(quiz: String) {
    Text(
        text = buildAnnotatedString { append(quiz) },
        color = Color.White,
        fontSize = 30.sp,
        fontFamily = songMyung,
        fontWeight = FontWeight.Normal,
    )
}