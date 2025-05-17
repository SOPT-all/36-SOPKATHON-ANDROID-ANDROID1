package com.sopt.at.sopkathon.team1.presentation.map

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.core.component.TopBar
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalSopkatonColorsProvider

@Composable
fun MapScreen(
    onNavigateToProductList: (String) -> Unit,
    onNavigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
){
    Surface (
        color = LocalSopkatonColorsProvider.current.Primary500,
        modifier = modifier
    ) {
        Column (
            modifier = modifier.systemBarsPadding()
        ){
            TopBar()
            Box(
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    painter = painterResource(R.drawable.img_map), // ← 지도 이미지
                    contentDescription = "지도",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(top = 70.dp)
                )
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.img_strawberry),
                    contentDescription = "딸기",
                    modifier = Modifier.size(48.dp)
                        .absoluteOffset(x = 240.dp, y = 376.dp)
                        .clickable {
                            onNavigateToProductList("딸기")
                        }
                )
                FloatingActionButton(
                    onClick = { onNavigateToHome()},
                    shape = CircleShape,
                    containerColor = LocalSopkatonColorsProvider.current.White,
                    contentColor = LocalSopkatonColorsProvider.current.Primary500,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(20.dp)
                        .padding(bottom = 20.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_home),
                        contentDescription = "Home",
                        modifier = Modifier.size(40.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ShowMapScreen(){
    MapScreen({}, {})
}