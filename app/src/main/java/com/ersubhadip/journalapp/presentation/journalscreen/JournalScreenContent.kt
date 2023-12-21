package com.ersubhadip.journalapp.presentation.journalscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ersubhadip.journalapp.presentation.journalscreen.components.JournalBodyTextField
import com.ersubhadip.journalapp.presentation.journalscreen.components.JournalTitleTextField
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.JournalScreenState
import com.ersubhadip.journalapp.presentation.utils.MyPaddingValues

@Composable
fun JournalScreenContent(
    modifier: Modifier = Modifier,
    journalScreenState: JournalScreenState.Success,
    lazyListState: LazyListState = rememberLazyListState(),
    onJournalTitleTextChange: (String) -> Unit,
    onJournalBodyTextChange: (String) -> Unit,
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState,
        contentPadding = PaddingValues(MyPaddingValues.MEDIUM),
    ) {
        item {
            JournalTitleTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                journalTitleTextFieldState = journalScreenState.journalTitleTextFieldState,
                onJournalTitleChanged = onJournalTitleTextChange,
            )

            Spacer(modifier = Modifier.height(MyPaddingValues.MEDIUM))

            JournalBodyTextField(
                modifier = Modifier
                    .fillMaxSize(),
                journalBodyTextFieldState = journalScreenState.journalBodyTextFieldState,
                onJournalBodyTextChange = onJournalBodyTextChange,
            )
        }
    }
}
