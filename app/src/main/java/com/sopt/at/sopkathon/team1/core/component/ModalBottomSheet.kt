package com.sopt.at.sopkathon.team1.core.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalSopkatonColorsProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.LocalTypographyProvider
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.Primary900
import com.sopt.at.sopkathon.team1.core.designsystem.ui.theme.defaultSopkatonColors
import com.sopt.at.sopkathon.team1.core.extension.noRippleClickable
import com.sopt.at.sopkathon.team1.core.extension.toDecimalFormat

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductBottomSheet(
    productName: String,
    price: Int,
    quantity: Int,
    onQuantityChange: (Int) -> Unit,
    onDismiss: () -> Unit,
    onPurchase: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = LocalSopkatonColorsProvider.current
    val typography = LocalTypographyProvider.current

        Box(modifier = modifier
            .width(360.dp)
            .height(273.dp)) {
            ModalBottomSheet(
                onDismissRequest = onDismiss,
                sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
                containerColor = colors.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(horizontal = 24.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "상품 선택",
                            style = typography.head_eb_18,
                            color = colors.Gray800
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        IconButton(onClick = onDismiss, modifier = Modifier.size(24.dp)) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_close),
                                contentDescription = "닫기",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colors.Primary100, shape = RoundedCornerShape(16.dp))
                            .padding(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = productName,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = typography.body_r_12,
                                color = colors.Gray800
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            IconButton(onClick = onDismiss, modifier = Modifier.size(24.dp)) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_close),
                                    contentDescription = "닫기",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(
                            modifier = Modifier
                                .width(86.dp)
                                .height(32.dp)
                                .background(
                                    color = colors.White,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .border(
                                    width = 1.dp,
                                    color = colors.Primary300,
                                    shape = RoundedCornerShape(8.dp)
                                )
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = {
                                    Log.d("onClick", quantity.toString())
                                    if (quantity > 1) onQuantityChange(quantity - 1)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_minus),
                                    contentDescription = "Minus"
                                )
                            }

                            Box(
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = quantity.toString(),
                                    style = typography.title_sb_14,
                                    color = colors.Gray900
                                )
                            }

                            IconButton(
                                onClick = {
                                    Log.d("onClick", quantity.toString())
                                    onQuantityChange(quantity + 1)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxHeight()
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_plus),
                                    contentDescription = "Plus"
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))
                    Text(
                        text = "${(price*quantity).toDecimalFormat()} 원",
                        style = typography.head_eb_28.merge(Primary900),
                        modifier = Modifier.fillMaxWidth()
                            .padding(bottom = 16.dp),
                        textAlign = TextAlign.End
                    )
                    CustomButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp),
                        text = "구매하기",
                        onClick = onPurchase
                    )
                }
            }
        }
}

@Composable
fun ProductBottomSheetPreviewScreen() {
    var isVisible by remember { mutableStateOf(true) }
    var quantity by remember { mutableStateOf(1) }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(defaultSopkatonColors.White)) {
        Text(
            text = "이곳은 더미 배경 화면입니다.",
            modifier = Modifier
                .padding(16.dp),
            color = Color.Black
        )

        ProductBottomSheet(
            productName = "바치랑바다랑 킹스베리 딸기 논산 대왕 왕딸기 1팩",
            quantity = quantity,
            onQuantityChange = { quantity = it },
            onDismiss = { isVisible = false },
            onPurchase = { },
            price = 0
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProductBottomSheetPreviewWrapper() {
    var isVisible by remember { mutableStateOf(false) }
    var quantity by remember { mutableStateOf(1) }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "이곳은 더미 배경 화면입니다.",
            modifier = Modifier
                .padding(16.dp)
                .noRippleClickable{
                    isVisible = !isVisible
                },
            color = Color.Black
        )
        if(isVisible) {
            ProductBottomSheet(
                productName = "바치랑바다랑 킹스베리 딸기 논산 대왕 왕딸기 1팩",
                quantity = quantity,
                onQuantityChange = { quantity = it },
                onDismiss = { isVisible = false },
                onPurchase = { },
                price = 0
            )
        }
    }
}
