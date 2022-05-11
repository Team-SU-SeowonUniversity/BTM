package com.teamsu.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.R

// Set of Material typography styles to start with
val helvetica = FontFamily(
    Font(R.font.helvetica_bold, FontWeight.Bold, FontStyle.Normal),
)
val songMyung = FontFamily(
    Font(R.font.song_myung_regular, FontWeight.Normal, FontStyle.Normal),
)
val naNumPenScript = FontFamily(
    Font(R.font.nanum_pen_script_regular, FontWeight.Normal, FontStyle.Normal)
)


val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)