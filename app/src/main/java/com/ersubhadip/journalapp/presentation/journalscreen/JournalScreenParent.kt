package com.ersubhadip.journalapp.presentation.journalscreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ersubhadip.journalapp.presentation.components.ErrorComposable
import com.ersubhadip.journalapp.presentation.components.LoadingComposable
import com.ersubhadip.journalapp.presentation.journalscreen.components.JournalScreenTopAppBar
import com.ersubhadip.journalapp.presentation.journalscreen.uistate.JournalScreenState
import com.ersubhadip.journalapp.presentation.utils.MyPaddingValues
import com.mohamedrejeb.richeditor.model.rememberRichTextState

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
@Preview
fun JournalScreenParent(
    journalScreenViewModel: JournalScreenViewModel = hiltViewModel(),
) {
    val richTextEditorState = rememberRichTextState()
    val journalScreenState by journalScreenViewModel.journalScreenState.collectAsStateWithLifecycle()
    val lazyListState = rememberLazyListState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .imePadding()
            .padding(bottom = MyPaddingValues.VERY_LARGE),
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
                            onBoldTextIconClicked = {
                                richTextEditorState.toggleSpanStyle(
                                    SpanStyle(
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            },

                            onItalicTextIconClicked = {
                                richTextEditorState.toggleSpanStyle(
                                    SpanStyle(
                                        fontStyle = FontStyle.Italic
                                    )
                                )
                            },

                            onUnderlineTextIconClicked = {
                                richTextEditorState.toggleSpanStyle(
                                    SpanStyle(
                                        textDecoration = TextDecoration.Underline,
                                    )
                                )
                            },

                            isOrderedListEnabled = richTextEditorState.isUnorderedList,

                            onBulletListIconClicked = {
                                richTextEditorState.toggleUnorderedList()
                            },

                            isNumberedListEnabled = richTextEditorState.isOrderedList,

                            onNumberedListIconClicked = {
                                richTextEditorState.toggleOrderedList()
                            },

                            spanStyle = richTextEditorState.currentSpanStyle,
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

private const val TAG = "journalscreenparent"
