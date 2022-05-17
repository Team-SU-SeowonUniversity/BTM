package com.teamsu.presentation.main.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.ui.theme.MainButtonColor
import com.teamsu.presentation.ui.theme.songMyung

@Composable
fun CustomMainButton(
    textValue: String,
) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(MainButtonColor),
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(130.dp)
            .height(100.dp)
    ) {
        Text(
            text = textValue,
            fontWeight = FontWeight.Normal,
            fontSize = 35.sp,
            fontFamily = songMyung,
            color = Color.Black
        )
    }
}