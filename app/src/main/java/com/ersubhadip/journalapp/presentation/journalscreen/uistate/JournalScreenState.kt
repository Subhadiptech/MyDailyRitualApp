package com.ersubhadip.journalapp.presentation.journalscreen.uistate

import com.ersubhadip.journalapp.presentation.components.TextFieldState

sealed class JournalScreenState {
    data object Loading: JournalScreenState()
    data class Error(val error: String): JournalScreenState()

    data class Success(
        val journalTitleTextFieldState: TextFieldState = TextFieldState(
            label = "title",
            placeholder = "enter title",
        ),

        val journalBodyTextFieldState: TextFieldState = TextFieldState(
            label = "journal",
            placeholder = "your journal...",
        )
    ): JournalScreenState()
}
