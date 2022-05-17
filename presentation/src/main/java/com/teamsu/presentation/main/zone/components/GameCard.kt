package com.teamsu.presentation.main.zone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.ui.theme.QuizButtonColor
import com.teamsu.presentation.ui.theme.songMyung

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GameCard(
    image: Painter,
    textValue: String
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(150.dp)
            .height(200.dp)
            .clickable { },
        backgroundColor = QuizButtonColor,
        onClick = { }
    ) {
        Image(
            painter = image,
            contentDescription = "",
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .padding(bottom = 50.dp),
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = textValue,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = songMyung
                )
            }
        }
    }
}
