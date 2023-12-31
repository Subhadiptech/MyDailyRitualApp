package com.ersubhadip.journalapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ersubhadip.journalapp.presentation.utils.MyPaddingValues

@Composable
fun ErrorComposable(
    modifier: Modifier = Modifier,
    error: String = "",
    shouldShowRetryButton: Boolean = false,
    onRetryButtonClick: () -> Unit = {},
) {
    Box(modifier = modifier) {
        Column(modifier = Modifier.align(Alignment.Center), horizontalAlignment = Alignment.CenterHorizontally,) {
            Text(text = error, color = MaterialTheme.colorScheme.error)

            if (shouldShowRetryButton) {
                Spacer(modifier = Modifier.padding(MyPaddingValues.MEDIUM))
                Button(onClick = onRetryButtonClick) {
                    Text(text = "Retry")
                }
            }
        }
    }
}