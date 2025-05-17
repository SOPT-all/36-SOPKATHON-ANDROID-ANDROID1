package com.sopt.at.sopkathon.team1.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class ProductListResponse(
    var info: List<ProductInfo>? = null
)

@Serializable
data class ProductInfo(
    var id: Int? = null,
    var title: String? = null,
    var image: String? = null,
    var region: String? = null,
    var body: String? = null,
    var price: Int? = null,
    var feature: String? = null,
    var flavor: String? = null,
    var shape: String? = null,
    var storage: String? = null,
    var seller: String? = null
)