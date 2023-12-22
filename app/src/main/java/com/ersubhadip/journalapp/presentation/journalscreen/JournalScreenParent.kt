package com.ersubhadip.journalapp.presentation.journalscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ersubhadip.journalapp.presentation.components.ErrorComposable
import com.ersubhadip.journalapp.presentation.components.LoadingComposable
import com.ersubhadip.journalapp.presentation.journalscreen.components.JournalScreenTopAppBar
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.JournalScreenState
import com.ersubhadip.journalapp.presentation.utils.MyPaddingValues
import com.mohamedrejeb.richeditor.model.rememberRichTextState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreenParent(
    journalScreenViewModel: JournalScreenViewModel = hiltViewModel()
) {
    val richTextEditorState = rememberRichTextState()
    val journalScreenState by journalScreenViewModel.journalScreenState.collectAsStateWithLifecycle()
    val lazyListState = rememberLazyListState()
    var currentSpanStyle by remember {
        mutableStateOf(
            SpanStyle(
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal
            )
        )
    }
    richTextEditorState.addSpanStyle(currentSpanStyle)

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
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

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        JournalScreenTopAppBar(
                            formattingIconsState = currentScreenState.formattingIconsState,
                            onBoldTextIconClicked = {
                                currentSpanStyle = currentSpanStyle.copy(
                                    fontWeight = if (currentSpanStyle.fontWeight == FontWeight.Bold) FontWeight.Normal else FontWeight.Bold
                                )

                                journalScreenViewModel.onBoldTextIconClicked(
                                    currentFontWeight = currentSpanStyle.fontWeight
                                )
                            },

                            onItalicTextIconClicked = {
                                currentSpanStyle = currentSpanStyle.copy(
                                    fontStyle = if (currentSpanStyle.fontStyle == FontStyle.Normal) FontStyle.Italic else FontStyle.Normal
                                )

                                journalScreenViewModel.onItalicTextIconClicked(
                                    currentFontStyle = currentSpanStyle.fontStyle
                                )
                            }
                        )
                    }
                ) {
                    JournalScreenContent(
                        modifier = Modifier
                            .padding(it)
                            .fillMaxSize(),
                        journalScreenState = currentScreenState,
                        lazyListState = lazyListState,
                        onJournalTitleTextChange = journalScreenViewModel::onJournalTitleTextFieldChange,
                        richTextEditorState = richTextEditorState,
                    )
                }
            }
        }
    }
}
