package com.sopt.at.sopkathon.team1.data.service

import com.sopt.at.sopkathon.team1.data.dto.base.DummyBaseResponse
import com.sopt.at.sopkathon.team1.data.dto.request.DummyServiceRequest
import com.sopt.at.sopkathon.team1.data.dto.response.DummyServiceResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface Team1Service {

    @POST("/api/v1/servie")
    suspend fun postServiceData(
        @Body request: DummyServiceRequest
    ): DummyBaseResponse<DummyServiceResponse>

}