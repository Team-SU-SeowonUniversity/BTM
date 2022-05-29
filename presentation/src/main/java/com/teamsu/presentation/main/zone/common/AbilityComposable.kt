package com.teamsu.presentation.main.zone.common

import android.graphics.Point
import androidx.compose.animation.core.FloatTweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.ui.theme.songMyung

@Composable
fun BarChart(
    ability: List<String>,
    point: List<Point>
) {
    val score = listOf(100,75,50,25,0)
    var start by remember { mutableStateOf(false) }
    val heightPre by animateFloatAsState(
        targetValue = if (start) 1f else 0f,
        animationSpec = FloatTweenSpec(duration = 1000)
    )

    Row(
        modifier = Modifier.padding(start = 25.dp)
    ) {
        Column(
            modifier = Modifier
                .height(230.dp)
                .padding(end = 5.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.End
        ) {
            for(i in score.indices) {
                Text(
                    text = score[i].toString(),
                    fontFamily = songMyung,
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    color = Color.White
                )
            }
        }

        Column {
            Box(
                modifier = Modifier
                    .width(300.dp)
                    .height(250.dp)
            ) {
                Canvas(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    drawLine(
                        start = Offset(10f, 600f),
                        end = Offset(10f, 0f),
                        color = Color.Black,
                        strokeWidth = 6f
                    )

                    drawLine(
                        start = Offset(10f, 600f),
                        end = Offset(870f, 600f),
                        color = Color.Black,
                        strokeWidth = 6f
                    )

                    start = true

                    for (p in point) {
                        drawRect(
                            color = Color.Red,
                            topLeft = Offset(p.x + 30f, 600 - (600 - p.y) * heightPre),
                            size = Size(50f, (600 - p.y) * heightPre)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .width(350.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (i in ability.indices) {
                    Text(
                        text = ability[i],
                        fontFamily = songMyung,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}
