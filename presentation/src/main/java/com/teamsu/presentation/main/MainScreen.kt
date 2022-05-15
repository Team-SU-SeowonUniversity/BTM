package com.teamsu.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.R
import com.teamsu.presentation.ui.theme.BackgroundColor
import com.teamsu.presentation.ui.theme.MainButtonColor
import com.teamsu.presentation.ui.theme.songMyung

@Preview
@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column {
            MainLogoRow(
                firstText = "뇌",
                restText = "를"
            )
            MainLogoRow(
                firstText = " 훈",
                restText = "련하는"
            )
            MainLogoRow(
                firstText = "  아",
                restText = "침"
            )
        }
        Spacer(modifier = Modifier.height(40.dp))
        Column {
            ButtonRow(
                buttonText1 = stringResource(id = R.string.percept),
                buttonText2 = stringResource(id = R.string.memory)
            )
            ButtonRow(
                buttonText1 = stringResource(id = R.string.instinctive),
                buttonText2 = stringResource(id = R.string.calculation)
            )
            ButtonRow(
                buttonText1 = stringResource(id = R.string.analysis),
                buttonText2 = stringResource(id = R.string.state)
            )
        }
    }
}

@Composable
fun ButtonRow(
    buttonText1: String,
    buttonText2: String,
) {
    Row {
        CustomMainButton(buttonText1)
        Spacer(modifier = Modifier.width(30.dp))
        CustomMainButton(buttonText2)
    }
    Spacer(modifier = Modifier.height(20.dp))
}

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

@Composable
fun MainLogoRow(
    firstText: String,
    restText: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = firstText,
            fontWeight = FontWeight.Normal,
            fontSize = 45.sp,
            fontFamily = songMyung,
            color = Color.Black
        )
        Text(
            text = restText,
            fontWeight = FontWeight.Light,
            fontSize = 33.sp,
            fontFamily = songMyung,
            color = Color.Black
        )
    }
}
