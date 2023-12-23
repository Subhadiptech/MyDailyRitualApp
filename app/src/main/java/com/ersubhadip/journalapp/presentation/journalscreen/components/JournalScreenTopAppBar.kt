package com.ersubhadip.journalapp.presentation.journalscreen.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreenTopAppBar(
    modifier: Modifier = Modifier,
    onBoldTextIconClicked: () -> Unit,
    onItalicTextIconClicked: () -> Unit,
    onUnderlineTextIconClicked: () -> Unit,
    spanStyle: SpanStyle,
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
                onBoldTextIconClicked = onBoldTextIconClicked,
                isBoldTextEnabled = spanStyle.fontWeight == FontWeight.Bold
            )

            ItalicTextActionIconButton (
                modifier = Modifier.align(Alignment.CenterVertically),
                onItalicTextIconClicked = onItalicTextIconClicked,
                isItalicTextEnabled = spanStyle.fontStyle == FontStyle.Italic,
            )

            UnderlineTextActionIconButton(
                modifier = Modifier.align(Alignment.CenterVertically),
                onUnderlineTextIconClicked = onUnderlineTextIconClicked,
                isUnderlineTextEnabled = spanStyle.textDecoration == TextDecoration.Underline,
            )
        }
    )
}

