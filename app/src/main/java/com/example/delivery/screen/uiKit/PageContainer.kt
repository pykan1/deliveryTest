package com.example.delivery.screen.uiKit

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotApplyResult
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DeliveryPageContainer(
    modifier: Modifier = Modifier,
    background: Color,
    isLoading: State<Boolean> = mutableStateOf(false),
    fill: Boolean = true,
    header: @Composable (() -> Unit)? = null,
    content: @Composable BoxScope.() -> Unit,
    footer: @Composable (BoxScope.() -> Unit)? = null,
) {
    val localFocusManager = LocalFocusManager.current
    var modifier = modifier.background(background)
    modifier = if (fill) {
        modifier.fillMaxHeight()
    } else {
        modifier.padding(bottom = 8.dp)
    }


    Column(
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    localFocusManager.clearFocus()
                })
            }
    ) {
        header?.invoke()
        Box(
            modifier = Modifier
                .weight(1f, fill)
        ) {
            content()
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            footer?.invoke(this)
        }

    }


    if (isLoading.value) {
        LoadingView(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5F))
        )
    }
}

@Composable
fun LoadingView(modifier: Modifier = Modifier.fillMaxSize()) {
    Box(modifier) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center),
        )
    }

}
