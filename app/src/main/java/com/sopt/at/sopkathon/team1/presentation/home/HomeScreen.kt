package com.sopt.at.sopkathon.team1.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.sopt.at.sopkathon.team1.core.component.FinishPurchaseDialog
import com.sopt.at.sopkathon.team1.core.component.TopBar
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Gray900
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalSopkatonColorsProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalTypographyProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Primary500
import com.sopt.at.sopkathon.team1.presentation.home.component.LevelComponent

@Composable
fun HomeScreen(
    onNavigateToProductList: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Market(
        onNavigateToProductList = onNavigateToProductList,
        modifier = modifier
    )
}

@Composable
fun Market(
    onNavigateToProductList: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val userInfo by viewModel.userInfo.collectAsStateWithLifecycle()
    val categories by viewModel.categories.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getUserInfo()
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Primary500)
            .statusBarsPadding()
    ) {
        TopBar()
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {
            item {
                LevelComponent(
                    nickname = userInfo.username.toString(),
                    level = userInfo.level ?: 0,
                    maxPrice = userInfo.maxPrice ?: 0,
                    totalPrice = userInfo.totalPrice ?: 0,
                )
            }

            item {
                Surface(
                    color = LocalSopkatonColorsProvider.current.GrayBackground,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(32.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        categories.forEach { category ->
                            Section(
                                category = category
                            ){
                                onNavigateToProductList(it)
                            }
                        }
                        Spacer(modifier = Modifier.navigationBarsPadding().height(18.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun Section(
    category: CategoryData,
    onNavigateToProductList: (String) -> Unit
) {
    Column(

    ) {
        // 카테고리 제목
        Text(
            text = stringResource(id = category.title),
            style = LocalTypographyProvider.current.head_eb_28.merge(Gray900),
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        // 가로 스크롤 카드 리스트
        LazyRow(
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(category.items) { item ->
                ItemCard(item) { onNavigateToProductList(item.name) }
            }
        }
    }
}

@Composable
fun ItemCard(
    item: ItemData,
    onclick: (String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = LocalSopkatonColorsProvider.current.White,
        ),
        modifier = Modifier
            .size(width = 126.dp, height = 156.dp)
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(24.dp),
                ambientColor = Color(0x404F6450)
            )
            .clickable { onclick(item.name) }
            .background(LocalSopkatonColorsProvider.current.GrayBackground),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 14.dp,
                    top = 13.dp,
                    end = 12.dp,
                    bottom = 7.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = item.imageResId),
                contentDescription = item.name,
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(9.dp))
            Text(
                text = item.name,
                style = LocalTypographyProvider.current.head_eb_18,
                color = LocalSopkatonColorsProvider.current.Primary500
            )
        }
    }
}

@Preview
@Composable
fun ShowHomeScreen(){
    HomeScreen(
        onNavigateToProductList = {}
    )
}