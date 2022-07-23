@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalPagerApi::class)

package com.teamsu.presentation.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.teamsu.presentation.R
import com.teamsu.presentation.start.components.ManagerTextField
import com.teamsu.presentation.start.components.SeniorLoginTextField
import com.teamsu.presentation.ui.theme.BackgroundColor
import com.teamsu.presentation.ui.theme.naNumPenScript
import kotlinx.coroutines.launch

@Preview
@Composable
internal fun StartScreen() {
    val (phoneNumber, setPhoneNumber) = remember { mutableStateOf("") }
    val (id, setId) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val pagerState = rememberPagerState(pageCount = 2)
    val tabList = listOf("노약자", "관리자")
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = buildAnnotatedString {
                append("뇌를\n")
                append(" 훈련하는\n")
                append("  아침")
            },
            color = Color.Black,
            fontSize = 60.sp,
            fontFamily = naNumPenScript,
            fontWeight = FontWeight.Normal
        )

        Spacer(modifier = Modifier.height(20.dp))

        TabRow(
            modifier = Modifier.width(250.dp),
            selectedTabIndex = pagerState.currentPage,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                    height = 2.dp,
                    color = Color.White
                )
            }
        ) {
            tabList.forEachIndexed { index, _ ->
                Tab(
                    selected = pagerState.currentPage == index,
                    text = {
                        Text(
                            text = tabList[index],
                            fontSize = 18.sp,
                            color = if (pagerState.currentPage == index) Color.White else Color.LightGray
                        )
                    },
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        HorizontalPager(
            state = pagerState,
            itemSpacing = 40.dp
        ) { page ->
            when (page) {
                0 -> SeniorLoginTextField(
                    hintText = stringResource(id = R.string.phone_number_hint),
                    value = phoneNumber,
                    setValue = setPhoneNumber,
                    keyboardController = keyboardController,
                    page = page
                )

                1 -> Column {
                    ManagerTextField(
                        hintText = stringResource(id = R.string.id_hint),
                        value = id,
                        setValue = setId,
                        keyboardController = keyboardController,
                        passwordInput = false
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    ManagerTextField(
                        hintText = stringResource(id = R.string.password_hint),
                        value = password,
                        setValue = setPassword,
                        keyboardController = keyboardController,
                        passwordInput = true
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            TextButton(
                onClick = { (context as? StartActivity)?.startMain() }
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = Color.Black,
                    fontSize = 40.sp,
                    fontFamily = naNumPenScript,
                    fontWeight = FontWeight.Normal
                )
            }

            Spacer(modifier = Modifier.width(30.dp))

            TextButton(
                onClick = { }
            ) {
                Text(
                    text = stringResource(id = R.string.signup),
                    color = Color.Black,
                    fontSize = 40.sp,
                    fontFamily = naNumPenScript,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}
