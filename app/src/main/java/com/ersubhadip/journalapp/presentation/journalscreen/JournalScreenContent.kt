package com.ersubhadip.journalapp.presentation.journalscreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ersubhadip.journalapp.presentation.journalscreen.components.JournalBodyTextField
import com.ersubhadip.journalapp.presentation.journalscreen.components.JournalTitleTextField
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.JournalScreenState
import com.ersubhadip.journalapp.presentation.utils.MyPaddingValues
import com.mohamedrejeb.richeditor.model.RichTextState
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditor
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditorColors
import com.mohamedrejeb.richeditor.ui.material3.RichTextEditorDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreenContent(
    modifier: Modifier = Modifier,
    journalScreenState: JournalScreenState.Success,
    lazyListState: LazyListState = rememberLazyListState(),
    onJournalTitleTextChange: (String) -> Unit,
    richTextEditorState: RichTextState,
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

            RichTextEditor(
                state = richTextEditorState,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = journalScreenState.journalBodyTextFieldState.label) },
                placeholder = { Text(text = journalScreenState.journalBodyTextFieldState.placeholder) },
            )
        }
    }
}
