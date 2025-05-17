package com.sopt.at.sopkathon.team1.presentation.dummyscreens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sopt.at.sopkathon.team1.core.extension.noRippleClickable

@Composable
fun HomeScreen(
    onNavigateToMyPage: (Long) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val userId by viewModel.userId.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(9.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "클릭 시 userId가 7로 바뀜 $userId",
            color = Color.White,
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(vertical = 12.dp, horizontal = 20.dp)
                .noRippleClickable {
                    viewModel.postService()
                    viewModel.updateUserId(7)
                }
        )
        Text(
            text = "마이페이지로 이동",
            color = Color.White,
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(30.dp)
                )
                .padding(vertical = 12.dp, horizontal = 20.dp)
                .noRippleClickable {
                    onNavigateToMyPage(userId)
                }
        )
    }
}