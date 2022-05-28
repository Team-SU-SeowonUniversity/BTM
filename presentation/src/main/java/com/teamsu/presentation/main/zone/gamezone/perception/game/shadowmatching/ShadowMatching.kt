@file:OptIn(ExperimentalMaterialApi::class)

package com.teamsu.presentation.main.zone.gamezone.perception.game.shadowmatching

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.teamsu.presentation.R
import com.teamsu.presentation.main.zone.components.CountDown
import com.teamsu.presentation.main.zone.components.CountDownViewModel
import com.teamsu.presentation.main.zone.components.Quiz
import com.teamsu.presentation.ui.theme.BackgroundColor
import com.teamsu.presentation.ui.theme.QuizButtonColor

@Composable
internal fun ShadowMatching(
    navController: NavController,
    countDownViewModel: CountDownViewModel,
    shadowMatchingViewModel: ShadowMatchingViewModel
) {
    val shadowImage = listOf(
        painterResource(id = R.drawable.test_one),
        painterResource(id = R.drawable.timer),
        painterResource(id = R.drawable.nyang),
        painterResource(id = R.drawable.back),
        painterResource(id = R.drawable.test_two)
    )
    val generalImage = listOf(
        painterResource(id = R.drawable.test_one),
        painterResource(id = R.drawable.timer),
        painterResource(id = R.drawable.nyang),
        painterResource(id = R.drawable.back),
        painterResource(id = R.drawable.test_two)
    )
    val count = 3

    LaunchedEffect(true){
        countDownViewModel.start(count)
        shadowMatchingViewModel.start(shadowImage, generalImage)
    }

    if(countDownViewModel.sec.value == 0) {
        countDownViewModel.stop()
        navController.popBackStack()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(30.dp)
    ) {
        Quiz("Q. 그림자와 같은 것은 무엇일까요?")

        Spacer(modifier = Modifier.height(5.dp))

        CountDown(viewModel = countDownViewModel)

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(20.dp)),
                painter = shadowImage[shadowMatchingViewModel.answer.value],
                contentDescription = " "
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 15.dp, end = 15.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            userScrollEnabled = false
        ) {
            items(shadowMatchingViewModel.viewList.size) { index ->
                ViewButton(image = generalImage[shadowMatchingViewModel.viewList[index]]) }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ViewButton(
    image: Painter
) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .width(150.dp)
            .height(130.dp),
        backgroundColor = QuizButtonColor,
        onClick = { }
    ) {
        Image(
            painter = image,
            contentDescription = " "
        )
    }
}
