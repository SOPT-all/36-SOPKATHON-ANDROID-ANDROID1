package com.sopt.at.sopkathon.team1.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseProductRequest(
    var userId: Long? = null,
    var productId: Long? = null,
    var quantity: Int? = null
)