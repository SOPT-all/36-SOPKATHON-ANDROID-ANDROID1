package com.sopt.at.sopkathon.team1.data.dto.response

data class ProductListResponse(
    var info: List<ProductInfo>
)

data class ProductInfo(
    var id: Int,
    var title: String,
    var image: String,
    var region: String,
    var body: String,
    var price: Int,
)