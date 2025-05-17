package com.sopt.at.sopkathon.team1.presentation.productdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.core.component.CustomButton
import com.sopt.at.sopkathon.team1.core.component.TopBar
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalSopkatonColorsProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalTypographyProvider
import com.sopt.at.sopkathon.team1.core.extension.toDecimalFormat

@Composable
fun ProductDetailScreen(
    onNavigateToLevel: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val colors = LocalSopkatonColorsProvider.current
    val typography = LocalTypographyProvider.current
    val state by viewModel.uiState.collectAsState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.GrayBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            TopBar()

            Image(
                painter = rememberAsyncImagePainter(state.image ?: ""),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f)
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(R.drawable.strawberry_profile),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = state.seller ?: "",
                        style = typography.title_sb_14,
                        color = colors.Primary500
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = state.title ?: "",
                    style = typography.head_eb_20,
                    color = colors.Primary900
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${state.price?.toDecimalFormat()}원",
                    style = typography.head_eb_28,
                    color = colors.Primary900
                )

                Spacer(modifier = Modifier.height(16.dp))

                Divider(
                    color = colors.Gray100,
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

//                DeliveryInfo(infoList = state.storage)

                Spacer(modifier = Modifier.height(16.dp))

//                FeatureSection(features = state.features)
            }
        }

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            text = "구매하기",
            onClick = onNavigateToLevel
        )
    }
}

@Composable
fun DeliveryInfo(infoList: List<String>) {
    val typography = LocalTypographyProvider.current
    val colors = LocalSopkatonColorsProvider.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        infoList.forEach { info ->
            Text(
                text = info,
                style = typography.body_r_12,
                color = colors.Gray600
            )
        }
    }
}

@Composable
fun FeatureSection(features: List<Pair<String, String>>) {
    val colors = LocalSopkatonColorsProvider.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colors.White,
                shape = RoundedCornerShape(24.dp)
            )
            .border(
                width = 1.dp,
                color = colors.Primary100,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(vertical = 16.dp, horizontal = 24.dp)
    ) {
        features.forEach { (title, content) ->
            FeatureItem(title = title, content = content)
        }
    }
}

@Composable
fun FeatureItem(title: String, content: String) {
    val typography = LocalTypographyProvider.current
    val colors = LocalSopkatonColorsProvider.current

    Column(modifier = Modifier.padding(vertical = 6.dp)) {
        Text(
            text = title,
            style = typography.head_eb_20,
            color = colors.Primary500
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = content,
            style = typography.body_r_14,
            color = colors.Gray800
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    MaterialTheme {
        ProductDetailScreen(onNavigateToLevel = {})
    }
}