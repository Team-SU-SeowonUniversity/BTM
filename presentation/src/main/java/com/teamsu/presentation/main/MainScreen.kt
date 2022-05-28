package com.teamsu.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.components.CustomMainButton
import com.teamsu.presentation.ui.theme.BackgroundColor
import com.teamsu.presentation.ui.theme.songMyung

@Composable
internal fun MainScreen(
    navController: NavController,
) {
    val buttonText = listOf(
        stringResource(id = R.string.perception),
        stringResource(id = R.string.memory),
        stringResource(id = R.string.instinctive),
        stringResource(id = R.string.calculation),
        stringResource(id = R.string.analysis),
        stringResource(id = R.string.state),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 45.sp,
                    )
                ) { append("뇌") }; append("를\n")

                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 45.sp,
                    )
                ) { append(" 훈") }; append("련하는\n")

                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 45.sp,
                    )
                ) { append("  아") }; append("침")
            },
            fontWeight = FontWeight.Light,
            fontSize = 33.sp,
            fontFamily = songMyung,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(40.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            userScrollEnabled = false,
            contentPadding = PaddingValues(start = 50.dp, end = 50.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(buttonText.size) { index ->
                CustomMainButton(zoneName = buttonText[index], navController = navController)
            }
        }
    }
}
