package com.sopt.at.sopkathon.team1.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserInfoResponse (
    @SerialName("userId")
    val id : Long,
    @SerialName("name")
    val name : String,
    @SerialName("totalPrice")
    val totalPrice : Int,
    @SerialName("level")
    val level : Int,
    @SerialName("maxPrice")
    val maxPrice : Int,
)