package com.sopt.at.sopkathon.team1.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.sopkathon.team1.data.dto.request.PurchaseProductRequest
import com.sopt.at.sopkathon.team1.data.dto.response.ProductInfo
import com.sopt.at.sopkathon.team1.data.repositoryimpl.Team1RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val team1RepositoryImpl: Team1RepositoryImpl
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProductInfo())
    val uiState: StateFlow<ProductInfo> = _uiState

    private val _count = MutableStateFlow(1)
    val count = _count.asStateFlow()

    fun loadProductDetail(productId: Long) {
        viewModelScope.launch {
            val result = team1RepositoryImpl.getProductInfo(productId)

            if(result.isSuccessful) {
                result.body()?.let {
                    _uiState.value = it.data ?: ProductInfo()
                }
            }
        }
    }
    fun postProductDetail(userId: Long, productId: Long, count: Int, action: () -> Unit = {}) {
        viewModelScope.launch {
            val result = team1RepositoryImpl.purchaseProduce(
                request = PurchaseProductRequest(
                    userId = userId,
                    productId = productId,
                    quantity = count
                )
            )

            if(result.isSuccessful) {
                result.body()?.let {
                    action()
                }
            }
        }
    }

    fun updateCount(count: Int){
        _count.value = count
    }
}
