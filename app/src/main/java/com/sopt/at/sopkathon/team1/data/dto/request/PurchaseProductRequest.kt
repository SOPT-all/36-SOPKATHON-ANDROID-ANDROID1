package com.sopt.at.sopkathon.team1.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseProductRequest(
    var userId: Int? = null,
    var productId: Int? = null,
    var quantity: Int? = null
)