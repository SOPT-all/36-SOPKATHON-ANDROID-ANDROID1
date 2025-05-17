package com.sopt.at.sopkathon.team1.presentation.productdetail

import android.util.Log
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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.core.component.CustomButton
import com.sopt.at.sopkathon.team1.core.component.FinishPurchaseDialog
import com.sopt.at.sopkathon.team1.core.component.ListViewTopBar
import com.sopt.at.sopkathon.team1.core.component.ProductBottomSheet
import com.sopt.at.sopkathon.team1.core.component.TopBar
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalSopkatonColorsProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalTypographyProvider
import com.sopt.at.sopkathon.team1.core.extension.toDecimalFormat
import com.sopt.at.sopkathon.team1.data.dto.type.RegionType

@Composable
fun ProductDetailScreen(
    modifier: Modifier = Modifier,
    productId: Long = 0L,
    price: Int = 0,
    onNavigateToHome: () -> Unit,
    viewModel: ProductDetailViewModel = hiltViewModel()
) {
    val count by viewModel.count.collectAsState()

    val colors = LocalSopkatonColorsProvider.current
    val typography = LocalTypographyProvider.current
    val state by viewModel.uiState.collectAsState()
    var isVisible by remember { mutableStateOf(false) }

    var isShowDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadProductDetail(productId)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.GrayBackground)
            .systemBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 100.dp)
        ) {
            ListViewTopBar(titleText = state.seller)

            Image(
                painter = rememberAsyncImagePainter(state.image ?: ""),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(bottomEnd = 32.dp, bottomStart = 32.dp)),
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
                        text = if (state.seller != null && state.region != null) {
                            val convertedRegion = when(state.region) {
                                RegionType.GONGJU.name -> RegionType.GONGJU.regionName
                                RegionType.ASAN.name -> RegionType.ASAN.regionName
                                RegionType.CHEONAN.name -> RegionType.CHEONAN.regionName
                                RegionType.DANGJIN.name -> RegionType.DANGJIN.regionName
                                RegionType.SEOSAN.name -> RegionType.SEOSAN.regionName
                                RegionType.BORYEONG.name -> RegionType.BORYEONG.regionName
                                RegionType.GYERYONG.name -> RegionType.GYERYONG.regionName
                                RegionType.NONSAN.name -> RegionType.NONSAN.regionName
                                RegionType.TAEAN.name -> RegionType.TAEAN.regionName
                                RegionType.HONGSEONG.name -> RegionType.HONGSEONG.regionName
                                RegionType.YESAN.name -> RegionType.YESAN.regionName
                                RegionType.CHEONGYANG.name -> RegionType.CHEONGYANG.regionName
                                RegionType.BUYEO.name -> RegionType.BUYEO.regionName
                                RegionType.SEOCHEON.name -> RegionType.SEOCHEON.regionName
                                RegionType.GEUMSAN.name -> RegionType.GEUMSAN.regionName
                                else -> ""
                            }
                            "${state.seller} · ${convertedRegion}"
                        } else {
                            state.seller ?: state.region ?: ""
                        },
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
                    text = "${price.toDecimalFormat()}원",
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

               DeliveryInfo(infoList = listOf(
                   "배송방법    무료배송",
                   "제주지역    3,000원",
                   "도서산간    3,000원"
               ))

                Spacer(modifier = Modifier.height(16.dp))

                FeatureSection(features = listOf(
                    Pair("상품 특징", state.feature.orEmpty()),
                    Pair("맛", state.flavor.orEmpty()),
                    Pair("크기와 모양", state.shape.orEmpty()),
                    Pair("보관 방법", state.storage.orEmpty())
                ))
            }
        }

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .navigationBarsPadding(),
            text = "구매하기",
            onClick = {
                isVisible = true
            }
        )
        if(isVisible){
            ProductBottomSheet(
                productName = state.title.orEmpty(),
                quantity = count,
                onQuantityChange = { count ->
                    Log.d("onQuantityChange", count.toString())
                    viewModel.updateCount(count)
                },
                onDismiss = {
                    isVisible = !isVisible
                },
                onPurchase = {
                    viewModel.postProductDetail(
                        userId = 1,
                        productId = productId,
                        count = count,
                        action = {
                            isShowDialog = true
                        }
                    )
                },
                price = price
            )
        }
    }

    if(isShowDialog) {
        isVisible = false

        FinishPurchaseDialog(
            setShowDialog = { isShowDialog = it },
        ) {
            onNavigateToHome()
        }
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
fun FeatureSection(
    features: List<Pair<String, String>>
) {
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