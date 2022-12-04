package com.youbook.fade.ui.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.youbook.fade.network.Resource
import com.youbook.fade.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ReviewListViewModel constructor(private val repository: ReviewRepository) : BaseViewModel(repository){

    private val _reviewResponse: MutableLiveData<Resource<ReviewResponse>> = MutableLiveData()
    val reviewResponse: LiveData<Resource<ReviewResponse>>
        get() = _reviewResponse

    suspend fun getUserOrder(
    ) = viewModelScope.launch {
        _reviewResponse.value = Resource.Loading
        _reviewResponse.value = repository.getReview()
    }
}

