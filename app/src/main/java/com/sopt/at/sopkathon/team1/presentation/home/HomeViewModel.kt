package com.sopt.at.sopkathon.team1.presentation.home

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.sopt.at.sopkathon.team1.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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
) : ViewModel() {
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
}