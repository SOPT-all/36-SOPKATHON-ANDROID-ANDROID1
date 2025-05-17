package com.sopt.at.sopkathon.team1.core.util

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.input.pointer.pointerInput

inline fun Modifier.pressedClickable(crossinline changePressed: (Boolean) -> Unit, crossinline onClick: () -> Unit): Modifier =  composed {
    pointerInput(Unit) {
        detectTapGestures(
            onPress = {
                changePressed(true)
                tryAwaitRelease()
                changePressed(false)
            },
            onTap = {
                onClick()
            }
        )

    }
}