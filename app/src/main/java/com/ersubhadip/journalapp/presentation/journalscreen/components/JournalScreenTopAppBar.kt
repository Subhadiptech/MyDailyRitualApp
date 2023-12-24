package com.ersubhadip.journalapp.presentation.journalscreen.components

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.ersubhadip.journalapp.presentation.journalscreen.components.topappbarcomponents.BoldTextActionIconButton
import com.ersubhadip.journalapp.presentation.journalscreen.components.topappbarcomponents.BulletListTextActionButton
import com.ersubhadip.journalapp.presentation.journalscreen.components.topappbarcomponents.ItalicTextActionIconButton
import com.ersubhadip.journalapp.presentation.journalscreen.components.topappbarcomponents.NumberedListTextActionIconButton
import com.ersubhadip.journalapp.presentation.journalscreen.components.topappbarcomponents.UnderlineTextActionIconButton

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun JournalScreenTopAppBar(
    modifier: Modifier = Modifier,
    onBoldTextIconClicked: () -> Unit,
    onItalicTextIconClicked: () -> Unit,
    onUnderlineTextIconClicked: () -> Unit,
    onBulletListIconClicked: () -> Unit,
    onNumberedListIconClicked: () -> Unit,
    spanStyle: SpanStyle,
    isOrderedListEnabled: Boolean,
    isNumberedListEnabled: Boolean,
) {
    MediumTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        modifier = modifier,
        title = {
            Text(text = "My Journal")
        },
        actions = {
            FlowRow {
                BoldTextActionIconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onBoldTextIconClicked = onBoldTextIconClicked,
                    isBoldTextEnabled = spanStyle.fontWeight == FontWeight.Bold
                )

                ItalicTextActionIconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onItalicTextIconClicked = onItalicTextIconClicked,
                    isItalicTextEnabled = spanStyle.fontStyle == FontStyle.Italic,
                )

                UnderlineTextActionIconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onUnderlineTextIconClicked = onUnderlineTextIconClicked,
                    isUnderlineTextEnabled = spanStyle.textDecoration == TextDecoration.Underline,
                )

                BulletListTextActionButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    onBulletListIconClicked = onBulletListIconClicked,
                    isBulletListEnabled = isOrderedListEnabled,
                )

                NumberedListTextActionIconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    isNumberedListEnabled = isNumberedListEnabled,
                    onNumberedListIconClicked = onNumberedListIconClicked,
                )
            }
        }
    )
}

