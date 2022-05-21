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
import androidx.navigation.NavController
import com.teamsu.presentation.main.MainNavigation
import com.teamsu.presentation.ui.theme.MainButtonColor
import com.teamsu.presentation.ui.theme.songMyung

@Composable
fun CustomMainButton(
    zoneName: String,
    navController: NavController,
) {
    Button(
        onClick = {
            when(zoneName) {
                "지각" ->
                    navController.navigate(MainNavigation.PERCEPTION.route)
                "기억" ->
                    navController.navigate(MainNavigation.MEMORY.route)
                "직감" ->
                    navController.navigate(MainNavigation.INSTINCTIVE.route)
                "계산" ->
                    navController.navigate(MainNavigation.CALCULATION.route)
                "분석" ->
                    navController.navigate(MainNavigation.ANALYSIS.route)
                "상태" ->
                    navController.navigate(MainNavigation.STATE.route)
            }
        },
        colors = ButtonDefaults.buttonColors(MainButtonColor),
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .width(130.dp)
            .height(100.dp)
    ) {
        Text(
            text = zoneName,
            fontWeight = FontWeight.Normal,
            fontSize = 35.sp,
            fontFamily = songMyung,
            color = Color.Black
        )
    }
}