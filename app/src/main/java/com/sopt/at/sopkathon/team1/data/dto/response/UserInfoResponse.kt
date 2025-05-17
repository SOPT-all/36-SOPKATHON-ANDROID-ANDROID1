package com.sopt.at.sopkathon.team1.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class UserInfoResponse (
    var id: Long? = null,
    var username: String? = null,
    var totalPrice: Int? = null,
    var level: Int? = null,
    var maxPrice: Int? = null
)