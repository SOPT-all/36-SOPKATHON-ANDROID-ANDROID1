package com.sopt.at.sopkathon.team1.data.service

import com.sopt.at.sopkathon.team1.data.dto.base.BaseResponse
import com.sopt.at.sopkathon.team1.data.dto.request.PurchaseProductRequest
import com.sopt.at.sopkathon.team1.data.dto.response.ProductInfo
import com.sopt.at.sopkathon.team1.data.dto.response.ProductListResponse
import com.sopt.at.sopkathon.team1.data.dto.response.PurchaseProductResponse
import com.sopt.at.sopkathon.team1.data.dto.response.UserInfoResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface Team1Service {

    @GET("/api/v1/user/{userId}")
    suspend fun getUserInfo(
        @Path("userId") request: Long
    ): BaseResponse<UserInfoResponse>

    @GET("/api/v1/product")
    suspend fun getProductList(
        @Query("category") category: String
    ): BaseResponse<ProductListResponse>

    @GET("/api/v1/product/{productId}")
    suspend fun getProductInfo(
        @Path("productId") productId: Long
    ): BaseResponse<ProductInfo>

    @POST("/api/v1/order")
    suspend fun purchaseProduce(
        @Body request: PurchaseProductRequest
    ): BaseResponse<PurchaseProductResponse>

}