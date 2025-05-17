package com.sopt.at.sopkathon.team1.presentation.dummyscreens.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sopt.at.sopkathon.team1.data.dto.request.DummyServiceRequest
import com.sopt.at.sopkathon.team1.data.repositoryimpl.Team1RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DummyHomeViewModel @Inject constructor(
    private val team1RepositoryImpl: Team1RepositoryImpl
) : ViewModel() {
    private val _userId = MutableStateFlow(0L)
    val userId = _userId.asStateFlow()

    private val _list = MutableStateFlow(emptyList<String>())
    val list = _list.asStateFlow()

    fun updateUserId(id: Long) {
        _userId.value = id
    }
    fun postService(){
        viewModelScope.launch {
//            team1RepositoryImpl.postService(
//                DummyServiceRequest(
//                    id = _userId.value
//                )
//            ).onFailure { error ->
//                val errorResponse = error.message
//                //실패 시 수행 작업
//                Log.d("failure", errorResponse.toString())
//            }.onSuccess { response ->
//                //성공 시 수행 작업
//                _list.update {
//                    response.info
//                }
//            }
        }
    }
}