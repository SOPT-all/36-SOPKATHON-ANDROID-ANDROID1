package com.sopt.at.sopkathon.team1.data.service

import com.sopt.at.sopkathon.team1.data.dto.base.DummyBaseResponse
import com.sopt.at.sopkathon.team1.data.dto.request.DummyServiceRequest
import com.sopt.at.sopkathon.team1.data.dto.request.UserInfoRequest
import com.sopt.at.sopkathon.team1.data.dto.response.DummyServiceResponse
import com.sopt.at.sopkathon.team1.data.dto.response.UserInfoResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Team1Service {

    @POST("/api/v1/servie")
    suspend fun postServiceData(
        @Body request: DummyServiceRequest
    ): DummyBaseResponse<DummyServiceResponse>

    @GET("/api/v1/user/{userId}")
    suspend fun getUserInfo(
        @Path("userId") request: Long
    ): DummyBaseResponse<UserInfoResponse>
}