package com.ersubhadip.journalapp.presentation.journalscreen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatItalic
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.FormattingIconsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreenTopAppBar(
    modifier: Modifier = Modifier,
    formattingIconsState: FormattingIconsState,
    onBoldTextIconClicked: () -> Unit,
    onItalicTextIconClicked: () -> Unit,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier,
        title = {
            Text(text = "Journal")
        },
        actions = {
            BoldTextActionIconButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                formattingIconsState = formattingIconsState,
                onBoldTextIconClicked = onBoldTextIconClicked
            )

            ItalicTextActionIconButton (
                modifier = Modifier.align(Alignment.CenterVertically),
                formattingIconsState = formattingIconsState,
                onItalicTextIconClicked = onItalicTextIconClicked,
            )
        }
    )
}

