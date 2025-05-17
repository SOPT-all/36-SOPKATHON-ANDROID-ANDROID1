package com.sopt.at.sopkathon.team1.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyServiceRequest(
    @SerialName("id")
    val id: Long
)