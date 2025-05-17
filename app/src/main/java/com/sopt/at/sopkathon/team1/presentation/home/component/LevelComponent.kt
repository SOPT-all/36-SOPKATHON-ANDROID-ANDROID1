package com.sopt.at.sopkathon.team1.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.sopt.at.sopkathon.team1.core.KeyStorage.LEVEL_IMG_LIST
import com.sopt.at.sopkathon.team1.core.KeyStorage.LEVEL_NAME_LIST
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Gray900
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalTypographyProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Primary100
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Primary500
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Primary700
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.White
import com.sopt.at.sopkathon.team1.core.extension.toDecimalFormat


@Composable
fun LevelComponent(
    nickname: String,
    level: Int,
    maxPrice: Int,
    totalPrice: Int,
    modifier: Modifier = Modifier
) {
    val typography = LocalTypographyProvider.current
    @DrawableRes val img = LEVEL_IMG_LIST[level]
    Box(
        modifier = modifier.fillMaxWidth()
            .wrapContentHeight()
            .padding(
                top = 14.dp,
                bottom = 16.dp,
                start = 20.dp,
                end = 20.dp
            )
    ) {
        Column(
            modifier = Modifier.align(Alignment.BottomStart)
        ) {
            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = nickname,
                    style = typography.head_eb_28.merge(White),
                    lineHeight = TextUnit.Unspecified
                )
                Text(
                    text = "님",
                    style = typography.head_eb_18.merge(White),
                    lineHeight = TextUnit.Unspecified
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = "LV.${level + 1} ${LEVEL_NAME_LIST[level]}",
                style = typography.head_eb_18.merge(White)
            )
            Spacer(Modifier.height(23.dp))
            ProgressBar(
                maxExp = maxPrice,
                progress = totalPrice.toFloat() / maxPrice.toFloat()
            )
            Spacer(Modifier.height(8.dp))
            if(level < 3) {
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Text(
                        text = "${(maxPrice - totalPrice).toDecimalFormat()}원 더 모으면",
                        style = typography.body_r_12.merge(White)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        text = LEVEL_NAME_LIST[level+1],
                        style = typography.title_sb_14.merge(White)
                    )
                    Spacer(Modifier.width(2.dp))
                    Text(
                        text = "이에유",
                        style = typography.body_r_12.merge(White)
                    )
                }
            }
            else{
                Text(
                    text = "못난이들의 왕! 충남 농산물을 정복했어요!",
                    style = typography.body_r_12.merge(White)
                )
            }
        }
        Image(
            painter = painterResource(img),
            contentDescription = "",
            modifier = Modifier.align(Alignment.BottomEnd)
                .size(172.dp)
        )
    }
}
@Composable
@Preview(showBackground = true)
fun LevelComponentPreview(){
    Column(
        Modifier.background(Primary500)
            .width(360.dp)
    ) {
        LevelComponent(
            nickname = "몬난이",
            level = 0,
            maxPrice = 100000,
            totalPrice = 70000,
        )
    }
}
@Composable
fun ProgressBar(
    maxExp: Int,
    progress: Float,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = Primary100
    val progressColor = Primary700

    val currentProgress = progress.coerceIn(0f, 1f)
    val typography = LocalTypographyProvider.current

    val barWidth = 124.dp

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .width(barWidth)
                .height(8.dp)
                .background(
                    color = backgroundColor,
                    shape = RoundedCornerShape(10.dp)
                )
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(currentProgress)
                    .background(
                        color = progressColor,
                        shape = RoundedCornerShape(10.dp)
                    )
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        Box(modifier = Modifier.width(barWidth)) {
            Text(
                text = "0",
                style = typography.body_r_12.merge(Gray900),
                modifier = Modifier.align(Alignment.CenterStart)
            )
            Text(
                text = maxExp.toDecimalFormat(),
                style = typography.body_r_12.merge(Gray900),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .offset(
                        x = barWidth - (maxExp.toDecimalFormat().length * 3.5).dp
                    )
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun ProgressBarPreview() {
    ProgressBar(
        maxExp = 100000,
        progress = 0.5f
    )
}