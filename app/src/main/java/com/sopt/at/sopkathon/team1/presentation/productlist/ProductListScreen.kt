package com.sopt.at.sopkathon.team1.presentation.productlist

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.runtime.setValue
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.sopt.at.sopkathon.team1.core.component.ListViewTopBar
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Gray100
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Gray200
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Gray600
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Gray900
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.GrayBackground
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalTypographyProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Primary100
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Primary500
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.White
import com.sopt.at.sopkathon.team1.core.extension.noRippleClickable
import com.sopt.at.sopkathon.team1.core.extension.toDecimalFormat
import com.sopt.at.sopkathon.team1.core.util.pressedClickable
import com.sopt.at.sopkathon.team1.data.dto.response.ProductInfo
import com.sopt.at.sopkathon.team1.data.dto.type.CategoryType

@Composable
fun ProductListScreen(
    startCategory: String,
    modifier: Modifier = Modifier,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    var selectedItem by remember { mutableStateOf(
        when(startCategory) {
            CategoryType.STRAWBERRY.categoryName -> CategoryType.STRAWBERRY
            CategoryType.APPLE.categoryName -> CategoryType.APPLE
            CategoryType.CHESTNUT.categoryName -> CategoryType.CHESTNUT
            CategoryType.WATERMELON.categoryName -> CategoryType.WATERMELON
            CategoryType.SHIITAKE.categoryName -> CategoryType.SHIITAKE
            CategoryType.CHILI.categoryName -> CategoryType.CHILI
            CategoryType.RICE.categoryName -> CategoryType.RICE
            else -> CategoryType.STRAWBERRY
        }
    ) }

    val categoryList = mutableListOf(
        CategoryType.STRAWBERRY,
        CategoryType.APPLE,
        CategoryType.CHESTNUT,
        CategoryType.WATERMELON,
        CategoryType.SHIITAKE,
        CategoryType.CHILI,
        CategoryType.RICE
    )

    val productList by viewModel.productList.collectAsStateWithLifecycle()

    viewModel.getProductList(startCategory)

    Scaffold(modifier = modifier.background(color = GrayBackground),
        topBar = {
            ListViewTopBar(Modifier.background(GrayBackground))
    }) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = GrayBackground)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categoryList.size) { index ->
                    CategoryItemLayout(categoryList[index], selectedItem) {
                        selectedItem = it
                        viewModel.getProductList(selectedItem.name)
                    }
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                contentPadding = PaddingValues(top = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(productList.size) { index ->
                    ProductItemLayout(productList[index]) {

                    }
                }
            }
        }
    }
}

@Composable
fun CategoryItemLayout(categoryType: CategoryType, selectedCategory: CategoryType, itemOnClick: (CategoryType) -> Unit) {
    var backgroundColor : Color
    var borderColor: Color

    if(categoryType == selectedCategory) {
        backgroundColor = Primary100
        borderColor = Primary500
    } else {
        backgroundColor = Color.Transparent
        borderColor = Gray200
    }

    Box(
        modifier = Modifier
            .height(32.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = backgroundColor, shape = RoundedCornerShape(16.dp))
            .border(1.dp, color = borderColor, shape = RoundedCornerShape(16.dp))
            .padding(horizontal = 20.dp, vertical = 6.dp)
            .noRippleClickable {
                itemOnClick.invoke(categoryType)
            }
    ) {
        Text(
            text = categoryType.categoryName,
            style = LocalTypographyProvider.current.title_sb_14,
            color = Gray900
        )
    }
}

@Composable
fun ProductItemLayout(productInfo: ProductInfo, itemOnClick: (String) -> Unit) {
    var isPressed by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(color = if(isPressed) Primary100 else White, shape = RoundedCornerShape(12.dp))
            .border(1.dp, color = Gray100, shape = RoundedCornerShape(12.dp))
            .clip(shape = RoundedCornerShape(12.dp))
            .padding(top = 8.dp, start = 8.dp, end = 12.dp, bottom = 8.dp)
            .pressedClickable(
                changePressed = {
                    isPressed = it
                },
                onClick = {

                }
            ),
    ) {
        Box(
            modifier = Modifier
                .width(80.dp)
                .height(104.dp)
                .border(1.dp, Gray100, RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = rememberAsyncImagePainter(productInfo.image),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .width(78.dp)
                    .height(102.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        Spacer(Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .padding(vertical = 4.dp)
        ) {
            Text(
                text = productInfo.title ?: "",
                style = LocalTypographyProvider.current.title_sb_14,
                color = Gray900,
                maxLines = 2
            )

            Spacer(Modifier.weight(1f))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = productInfo.region ?: "",
                    style = LocalTypographyProvider.current.body_r_12,
                    color = Gray600
                )

                Spacer(Modifier.weight(1f))

                Text(
                    text = "${productInfo.price?.toDecimalFormat()}원",
                    style = LocalTypographyProvider.current.head_eb_16,
                    color = Gray900
                )
            }
        }
    }

}