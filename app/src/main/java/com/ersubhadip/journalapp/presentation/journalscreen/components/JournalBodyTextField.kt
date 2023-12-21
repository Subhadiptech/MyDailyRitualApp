package com.ersubhadip.journalapp.presentation.journalscreen.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ersubhadip.journalapp.presentation.components.TextFieldState

@Composable
fun JournalBodyTextField(
    modifier: Modifier = Modifier,
    journalBodyTextFieldState: TextFieldState,
    onJournalBodyTextChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        value = journalBodyTextFieldState.text,
        onValueChange = onJournalBodyTextChange,
        label = { Text(text = journalBodyTextFieldState.label) },
        placeholder = { Text(text = journalBodyTextFieldState.placeholder) },
        isError = journalBodyTextFieldState.error.isNotBlank(),
    )
}
