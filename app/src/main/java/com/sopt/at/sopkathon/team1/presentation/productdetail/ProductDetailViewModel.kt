package com.sopt.at.sopkathon.team1.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.sopkathon.team1.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ProductDetailUiState(
    val title: String = "",
    val price: String = "",
    val seller: String = "",
    val imageResId: Int = R.drawable.strawberry,
    val profileImageResId: Int = R.drawable.strawberry_profile,
    val deliveryInfo: List<String> = emptyList(),
    val features: List<Pair<String, String>> = emptyList()
)

@HiltViewModel
class ProductDetailViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(ProductDetailUiState())
    val uiState: StateFlow<ProductDetailUiState> = _uiState

    init {
        loadProductDetail()
    }

    private fun loadProductDetail() {
        viewModelScope.launch {
            _uiState.value = ProductDetailUiState(
                title = "바치랑바다랑 킹스베리 딸기 논산 대왕 왕딸기 설향 한박스",
                price = "24,000원",
                seller = "바치랑바다랑",
                imageResId = R.drawable.strawberry,
                profileImageResId = R.drawable.strawberry_profile,
                deliveryInfo = listOf(
                    "배송방법 무료배송",
                    "제주지역 3,000원",
                    "도서산간 3,000원"
                ),
                features = listOf(
                    "상품 특징" to "자연 그대로의 얕은 갈색한 못난이 딸기입니다. 크기와 색이 고르지 않거나 작은 흠집이 있을 수 있지만, 신선도와 맛에는 전혀 문제가 없습니다.",
                    "맛" to "신선한 단맛과 상큼함이 가득한 딸기입니다. 그대로 먹어도 맛있고, 잼이나 스무디로 활용하기에도 좋습니다.",
                    "크기와 모양" to "크기는 다양하며, 모양이 일정하지 않을 수 있지만, 자연스럽게 자란 그대로를 담아, 신선하고 건강한 맛을 전달합니다.",
                    "보관 방법" to "신선도를 유지하기 위해 냉장 보관을 권장합니다. 3일 이내에 섭취하면 더욱 맛있게 즐길 수 있습니다."
                )
            )
        }
    }
}
