package com.ersubhadip.journalapp.presentation.journalscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatBold
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
fun BoldTextActionIconButton(
    modifier: Modifier = Modifier,
    formattingIconsState: FormattingIconsState,
    onBoldTextIconClicked: () -> Unit,
) {
    IconButton(
        onClick = onBoldTextIconClicked,
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .drawBehind {
                    drawRect(
                        color = if (formattingIconsState.isBoldTextEnabled) Color.Red.copy(
                            alpha = 0.6f
                        ) else Color.Transparent
                    )
                }
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Outlined.FormatBold,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground,
            )
        }

    }
}