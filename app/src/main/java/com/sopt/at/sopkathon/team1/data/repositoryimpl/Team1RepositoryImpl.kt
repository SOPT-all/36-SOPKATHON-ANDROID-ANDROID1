package com.sopt.at.sopkathon.team1.data.repositoryimpl

import com.sopt.at.sopkathon.team1.data.dto.request.DummyServiceRequest
import com.sopt.at.sopkathon.team1.data.dto.response.DummyServiceResponse
import com.sopt.at.sopkathon.team1.data.service.Team1Service
import javax.inject.Inject

class Team1RepositoryImpl @Inject constructor(
    private val service: Team1Service
) {
    suspend fun postService(request: DummyServiceRequest): Result<DummyServiceResponse> =
        runCatching {
            val response = service.postServiceData(request)
            response.data ?: throw Exception("No data in response")
        }
}