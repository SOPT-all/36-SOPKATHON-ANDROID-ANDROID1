package com.sopt.at.sopkathon.team1.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.data.repositoryimpl.Team1RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val team1RepositoryImpl: Team1RepositoryImpl
) : ViewModel() {
//    private val _uiState = MutableStateFlow(ProductDetailUiState())
//    val uiState: StateFlow<ProductDetailUiState> = _uiState

    private fun loadProductDetail(productId: Long) {
        viewModelScope.launch {
            val result = team1RepositoryImpl.getProductInfo(productId)

            if(result.isSuccessful) {
                result.body()?.let {
                    it.data
                }
            }
        }
    }
}
