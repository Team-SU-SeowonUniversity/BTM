@file:OptIn(ExperimentalComposeUiApi::class)

package com.teamsu.presentation.start.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.teamsu.presentation.ui.theme.naNumPenScript

@Composable
internal fun ManagerTextField(
    hintText: String,
    value: String,
    setValue: (String) -> Unit,
    keyboardController: SoftwareKeyboardController?,
    passwordInput: Boolean
) {
    Box {
        BasicTextField(
            value = value,
            onValueChange = setValue,
            textStyle = TextStyle(
                fontSize = 20.sp,
            ),
            singleLine = true,
            modifier = Modifier
                .width(250.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(5.dp)),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = if(passwordInput) { ImeAction.Done} else { ImeAction.Next }),
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
        if (value.isEmpty()) {
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