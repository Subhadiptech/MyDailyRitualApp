package com.ersubhadip.journalapp.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ersubhadip.journalapp.ui.theme.Nunito
import com.ersubhadip.journalapp.ui.theme.PrimaryBrown
import com.ersubhadip.journalapp.ui.theme.Whisper
import com.ersubhadip.journalapp.ui.theme.White

@Composable
fun ThemedTextField(
    fieldLabel: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    error: InputErrorType = InputErrorType.NO_ERROR
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = fieldLabel,
            fontSize = 12.sp,
            color = White.copy(0.6f),
            fontFamily = Nunito
        )
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = White,
                fontSize = 14.sp,
                fontFamily = Nunito
            ),
            keyboardOptions = keyboardOptions,
            cursorBrush = Brush.linearGradient(colors = listOf(White)),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .clip(RoundedCornerShape(8.dp))
                .border(width = 1.dp, color = White.copy(0.6f), shape = RoundedCornerShape(8.dp))
                .padding(vertical = 12.dp, horizontal = 6.dp)
        )
        AnimatedVisibility(
            visible = error != InputErrorType.NO_ERROR,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = if (error == InputErrorType.EMPTY) "$fieldLabel cannot be empty" else if (error == InputErrorType.INVALID) "$fieldLabel is invalid!" else "",
                fontSize = 8.sp,
                color = Color(0xffEF0000),
                fontFamily = Nunito
            )
        }
    }
}

enum class InputErrorType {
    NO_ERROR, EMPTY, INVALID
}


@Composable
@Preview
fun PrimaryButton(
    text: String = "Click Me",
    onClick: () -> Unit = {},
    marginTop: Dp = 0.dp,
    marginBottom: Dp = 0.dp,
    marginStart: Dp = 0.dp,
    marginEnd: Dp = 0.dp,
    isActive: Boolean = true,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = marginStart, end = marginEnd, top = marginTop, bottom = marginBottom)
            .clip(RoundedCornerShape(28.dp))
            .alpha(if (isActive) 1f else 0.4f)
            .background(PrimaryBrown)
            .clickable {
                if (isActive) {
                    onClick()
                }
            },
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontFamily = Whisper,
            modifier = Modifier.padding(20.dp)
        )
    }
}