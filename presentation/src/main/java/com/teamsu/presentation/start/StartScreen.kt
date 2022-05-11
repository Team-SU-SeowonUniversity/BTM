@file:OptIn(ExperimentalComposeUiApi::class)

package com.teamsu.presentation.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.R
import com.teamsu.presentation.ui.theme.BackgroundColor
import com.teamsu.presentation.ui.theme.naNumPenScript


@Preview
@Composable
internal fun StartScreen() {
    val (phoneNumber, setPhoneNumber) = remember { mutableStateOf("")}
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LogoText(logo = stringResource(id = R.string.logo))
        PhoneNumberEdit(
            hintText = stringResource(id = R.string.phone_number_hint),
            phoneNumber = phoneNumber,
            setPhoneNumber = setPhoneNumber,
            keyboardController = keyboardController
        )
        LoginButton(loginText = stringResource(id = R.string.login))
    }
}

@Composable
fun LoginButton(
    loginText: String
) {
    TextButton(
        onClick = { }
    ) {
        Text(
            text = loginText,
            color = Color.Black,
            fontSize = 50.sp,
            fontFamily = naNumPenScript,
            fontWeight = FontWeight.Normal
        )
    }
}

@Composable
fun PhoneNumberEdit(
    hintText: String,
    phoneNumber: String,
    setPhoneNumber: (String) -> Unit,
    keyboardController: SoftwareKeyboardController?
) {
    Box {
        BasicTextField(
            value = phoneNumber,
            onValueChange = setPhoneNumber,
            textStyle = TextStyle(
                fontSize = 20.sp,
            ),
            modifier = Modifier
                .width(250.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(5.dp)),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
            decorationBox = { innerTextField ->
                Row(
                    Modifier
                        .background(Color.White)
                        .padding(start = 10.dp, end = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    innerTextField()
                }
            },
        )
        if (phoneNumber.isEmpty()) {
            Text(
                modifier = Modifier.offset(x = 10.dp, y = 11.dp),
                text = hintText,
                fontFamily = naNumPenScript,
                color = Color.Gray,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun LogoText(
    logo: String,
) {
    Text(
        text = logo,
        color = Color.Black,
        fontSize = 80.sp,
        fontFamily = naNumPenScript,
        fontWeight = FontWeight.Normal
    )
}
