package com.teamsu.presentation.main.percept

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.teamsu.presentation.R
import com.teamsu.presentation.common.AreaName
import com.teamsu.presentation.common.BackWard
import com.teamsu.presentation.common.GameCard
import com.teamsu.presentation.ui.theme.BackgroundColor

@Preview
@Composable
fun PerceptScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(top = 20.dp)
        ) {
            BackWard()
            Spacer(modifier = Modifier.width(5.dp))
            AreaName(name = stringResource(id = R.string.percept))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            thickness = 2.dp,
            color = Color.Black,
        )
        Spacer(modifier = Modifier.height(20.dp))
        GameCard(
            image = painterResource(id = R.drawable.back),
            textValue = stringResource(id = R.string.fit_a_fragmented_photo)
        )
    }
}
