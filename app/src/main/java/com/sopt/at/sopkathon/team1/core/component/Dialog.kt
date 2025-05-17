package com.sopt.at.sopkathon.team1.core.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.White
import com.sopt.at.sopkathon.team1.core.extension.noRippleClickable

@Composable
fun FinishPurchaseDialog(
    setShowDialog: (Boolean) -> Unit = { },
    onClick: () -> Unit = { },
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        Column(
            modifier = Modifier
                .background(White, RoundedCornerShape(24.dp))
        ) {
            Box(
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .padding(end = 16.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_close),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .align(Alignment.CenterEnd)
                        .noRippleClickable {
                            setShowDialog(false)
                        }
                )
            }

            Image(
                painter = painterResource(R.drawable.img_character_thx),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(245.dp)
            )

            CustomButton(
                text = "메인화면으로",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                onClick = {
                    onClick.invoke()
                    setShowDialog(false)
                }
            )
        }
    }


}