package com.sopt.at.sopkathon.team1.data.repositoryimpl

import com.sopt.at.sopkathon.team1.data.dto.base.BaseResponse
import com.sopt.at.sopkathon.team1.data.dto.request.PurchaseProductRequest
import com.sopt.at.sopkathon.team1.data.dto.request.UserInfoRequest
import com.sopt.at.sopkathon.team1.data.dto.response.ProductInfo
import com.sopt.at.sopkathon.team1.data.dto.response.ProductListResponse
import com.sopt.at.sopkathon.team1.data.dto.response.PurchaseProductResponse
import com.sopt.at.sopkathon.team1.data.dto.response.UserInfoResponse
import com.sopt.at.sopkathon.team1.data.service.Team1Service
import retrofit2.Response
import javax.inject.Inject

class Team1RepositoryImpl @Inject constructor(
    private val service: Team1Service
) {
    suspend fun getUserInfo(request: UserInfoRequest): Result<UserInfoResponse> =
        runCatching {
            val response = service.getUserInfo(request.userId)
            response.data ?: throw Exception("No data in response")
        }

    suspend fun getProductList(category: String): Result<ProductListResponse> =
        runCatching {
            val response = service.getProductList(category)
            response.data ?: throw Exception("No data in response")
        }

    suspend fun getProductInfo(productId: Long): Result<ProductInfo> =
        runCatching {
            val response = service.getProductInfo(productId)
            response.data ?: throw Exception("No data in response")
        }

    suspend fun purchaseProduce(request: PurchaseProductRequest): Result<PurchaseProductResponse> =
        runCatching {
            val response = service.purchaseProduce(request)
            response.data ?: throw Exception("No data in response")
        }

}