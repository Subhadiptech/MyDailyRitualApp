package com.ersubhadip.journalapp.presentation.journalscreen.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.ersubhadip.journalapp.presentation.components.TextFieldState

@Composable
fun JournalTitleTextField(
    modifier: Modifier = Modifier,
    journalTitleTextFieldState: TextFieldState,
    onJournalTitleChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = journalTitleTextFieldState.text,
        onValueChange = onJournalTitleChanged,
        label = { Text(text = journalTitleTextFieldState.label) },
        placeholder = { Text(text = journalTitleTextFieldState.placeholder) },
        isError = journalTitleTextFieldState.error.isNotBlank(),
        textStyle = TextStyle(fontWeight = FontWeight.SemiBold)
    )
}