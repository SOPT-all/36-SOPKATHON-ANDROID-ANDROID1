package com.sopt.at.sopkathon.team1.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class PurchaseProductResponse(
    var orderId: Int? = null
)
