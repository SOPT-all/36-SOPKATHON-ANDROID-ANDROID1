package com.sopt.at.sopkathon.team1.presentation.productlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.sopkathon.team1.core.navigation.Route.ProductList
import com.sopt.at.sopkathon.team1.data.dto.response.ProductInfo
import com.sopt.at.sopkathon.team1.data.repositoryimpl.Team1RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val team1RepositoryImpl: Team1RepositoryImpl
) : ViewModel() {

    private val _productList = MutableStateFlow<List<ProductInfo>>(emptyList())
    val productList = _productList.asStateFlow()


    fun getProductList(category: String) = viewModelScope.launch {
        val result = team1RepositoryImpl.getProductList(category)

        if(result.isSuccessful) {
            result.body()?.let {
                _productList.emit(it.data?.info ?: emptyList())
            }
        }
    }
}