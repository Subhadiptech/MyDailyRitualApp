package com.ersubhadip.journalapp.presentation.journalscreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.JournalScreenState
import com.ersubhadip.journalapp.presentation.utils.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class JournalScreenViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _journalScreenState = MutableStateFlow<JournalScreenState>(JournalScreenState.Loading)
    val journalScreenState get() = _journalScreenState.asStateFlow()

    init {
        val journalId = savedStateHandle.get<String>(Constants.NAV_ARGS_KEY_JOURNAL_ID)
        if (journalId == null) {
            _journalScreenState.value = JournalScreenState.Success()
        } else {
            // TODO(Handle database retrieval of journal here)
        }
    }

    fun onJournalTitleTextFieldChange (newTitle: String) {
        val currentScreenState = _journalScreenState.value

        if (currentScreenState !is JournalScreenState.Success) return

        val titleTextFieldState = currentScreenState.journalTitleTextFieldState
        _journalScreenState.value = currentScreenState.copy(journalTitleTextFieldState = titleTextFieldState.copy(text = newTitle))
    }

    fun onJournalBodyTextFieldChange (newTitle: String) {
        val currentScreenState = _journalScreenState.value

        if (currentScreenState !is JournalScreenState.Success) return

        val journalBodyTextFieldState = currentScreenState.journalBodyTextFieldState
        _journalScreenState.value = currentScreenState.copy(journalBodyTextFieldState = journalBodyTextFieldState.copy(text = newTitle))
    }
}