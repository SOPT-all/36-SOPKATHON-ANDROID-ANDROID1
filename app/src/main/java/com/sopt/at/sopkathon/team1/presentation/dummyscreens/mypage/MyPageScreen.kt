package com.sopt.at.sopkathon.team1.presentation.dummyscreens.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sopt.at.sopkathon.team1.core.extension.noRippleClickable

@Composable
fun MyPageScreen(
    onNavigateToSetting: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "설정으로 이동",
            color = Color.White,
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(vertical = 12.dp, horizontal = 20.dp)
                .noRippleClickable {
                    onNavigateToSetting()
                }
        )
    }
}