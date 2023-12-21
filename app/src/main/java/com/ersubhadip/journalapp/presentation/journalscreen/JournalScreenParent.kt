package com.ersubhadip.journalapp.presentation.journalscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ersubhadip.journalapp.presentation.components.ErrorComposable
import com.ersubhadip.journalapp.presentation.components.LoadingComposable
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.JournalScreenState
import com.ersubhadip.journalapp.presentation.utils.MyPaddingValues
import com.mohamedrejeb.richeditor.model.rememberRichTextState

@Composable
fun JournalScreenParent(
    journalScreenViewModel: JournalScreenViewModel = hiltViewModel()
) {
    val richTextEditorState = rememberRichTextState()
    val journalScreenState by journalScreenViewModel.journalScreenState.collectAsStateWithLifecycle()
    val lazyListState = rememberLazyListState()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when (val currentScreenState = journalScreenState) {
            is JournalScreenState.Error -> {
                ErrorComposable(
                    modifier = Modifier.fillMaxSize(),
                    error = currentScreenState.error
                )
            }

            JournalScreenState.Loading -> {
                LoadingComposable(
                    modifier = Modifier
                        .size(MyPaddingValues.LARGE)
                )
            }

            is JournalScreenState.Success -> {
                JournalScreenContent(
                    modifier = Modifier.fillMaxSize(),
                    journalScreenState = currentScreenState,
                    lazyListState = lazyListState,
                    onJournalTitleTextChange = journalScreenViewModel::onJournalTitleTextFieldChange,
                    onJournalBodyTextChange = journalScreenViewModel::onJournalBodyTextFieldChange,
                )
            }
        }
    }
}