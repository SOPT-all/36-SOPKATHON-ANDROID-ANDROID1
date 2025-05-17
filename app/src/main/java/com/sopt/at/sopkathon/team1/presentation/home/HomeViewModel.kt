package com.sopt.at.sopkathon.team1.presentation.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.sopkathon.team1.R
import com.sopt.at.sopkathon.team1.data.dto.request.PurchaseProductRequest
import com.sopt.at.sopkathon.team1.data.dto.request.UserInfoRequest
import com.sopt.at.sopkathon.team1.data.dto.response.UserInfoResponse
import com.sopt.at.sopkathon.team1.data.repositoryimpl.Team1RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ItemData(
    val name: String,
    @DrawableRes val imageResId: Int
)

data class CategoryData(
    @StringRes val title: Int,
    val items: List<ItemData>
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val team1RepositoryImpl: Team1RepositoryImpl
) : ViewModel() {
    private val _userInfo = MutableStateFlow(UserInfoResponse(
        id = 0L,
        username = "",
        totalPrice = 0,
        level = 0,
        maxPrice = 0
    ))
    val userInfo = _userInfo.asStateFlow()

    private val _categories = MutableStateFlow(
        listOf(
            CategoryData(
                R.string.home_category_1,
                listOf(
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                )
            ),
            CategoryData(
                R.string.home_category_2,
                listOf(
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                )
            ),
            CategoryData(
                R.string.home_category_3,
                listOf(
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                )
            ),
            CategoryData(
                R.string.home_category_4,
                listOf(
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                    ItemData("딸기", R.drawable.img_strawberry),
                )
            ),
        )
    )
    val categories: StateFlow<List<CategoryData>> = _categories

    fun getUserInfo(){
        viewModelScope.launch {
            team1RepositoryImpl.getUserInfo(
                request = UserInfoRequest(1)
            ).onSuccess {
                _userInfo.value = it
            }.onFailure {
                it.printStackTrace()
            }

            team1RepositoryImpl.getProductList("")
            team1RepositoryImpl.getProductInfo(0)
            team1RepositoryImpl.purchaseProduce(PurchaseProductRequest(0))
        }
    }
}