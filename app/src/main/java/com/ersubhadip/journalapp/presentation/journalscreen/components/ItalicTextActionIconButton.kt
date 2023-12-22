package com.ersubhadip.journalapp.presentation.journalscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatItalic
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.FormattingIconsState

@Composable
fun ItalicTextActionIconButton(
    modifier: Modifier = Modifier,
    formattingIconsState: FormattingIconsState,
    onItalicTextIconClicked: () -> Unit,
) {
    IconButton(
        onClick = onItalicTextIconClicked,
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .drawBehind {
                    drawRect(
                        color = if (formattingIconsState.isItalicTextEnabled) Color.Red.copy(
                            alpha = 0.6f
                        ) else Color.Transparent
                    )
                }
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Outlined.FormatItalic,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}