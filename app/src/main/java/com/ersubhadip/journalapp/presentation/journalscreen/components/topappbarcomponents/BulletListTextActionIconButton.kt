package com.ersubhadip.journalapp.presentation.journalscreen.components.topappbarcomponents

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatListBulleted
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color

@Composable
fun BulletListTextActionButton(
    modifier: Modifier = Modifier,
    isOrderedListEnabled: Boolean,
    onOrderedListIconClicked: () -> Unit,
) {
    IconButton(
        onClick = onOrderedListIconClicked,
        modifier = modifier,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    drawRect(
                        color = if (isOrderedListEnabled) Color.Red.copy(
                            alpha = 0.6f
                        ) else Color.Transparent
                    )
                }
        ) {
            Icon(
                modifier = Modifier.fillMaxSize(),
                imageVector = Icons.Outlined.FormatListBulleted,
                contentDescription = null,
            )
        }
    }
}