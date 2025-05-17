package com.sopt.at.sopkathon.team1.core.component

import android.annotation.SuppressLint
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalSopkatonColorsProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalTypographyProvider
import com.sopt.at.sopkathon.team1.core.extension.noRippleClickable

@SuppressLint("RememberReturnType")
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true
) {
    val colors = LocalSopkatonColorsProvider.current
    val typographys = LocalTypographyProvider.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    val backgroundColor = when {
        !enabled -> colors.Gray200
        isPressed -> colors.Primary600
        else -> colors.Primary500
    }

    val contentColor = when {
        !enabled -> colors.Gray600
        else -> colors.White
    }

    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier
            .width(320.dp)
            .height(56.dp)
            .noRippleClickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor,
            disabledContainerColor = colors.Gray200,
            disabledContentColor = colors.Gray400
        )
    ) {
        Text(text, style = typographys.title_sb_18)
    }
}
