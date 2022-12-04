package com.youbook.fade.ui.fragment.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.youbook.fade.network.CommonResponse
import com.youbook.fade.network.Resource
import com.youbook.fade.ui.base.BaseViewModel
import com.youbook.fade.ui.fragment.new_dashboard.NewDashBoardResponseModel
import kotlinx.coroutines.launch

class ProfileViewModel(val repository: ProfileFragmentRepository) : BaseViewModel(repository) {

    private val _getOfferResponse: MutableLiveData<Resource<NewDashBoardResponseModel>> = MutableLiveData()
    val getDashboardResponse: LiveData<Resource<NewDashBoardResponseModel>>
        get() = _getOfferResponse

    private val _logoutResponse: MutableLiveData<Resource<CommonResponse>> = MutableLiveData()
    val logoutResponse: LiveData<Resource<CommonResponse>>
        get() = _logoutResponse

    suspend fun getDashBoardData(
        params: Map<String,String>
    ) = viewModelScope.launch {
        _getOfferResponse.value = Resource.Loading
        _getOfferResponse.value = repository.getDashBoardData(params)
    }

    suspend fun logoutUser(
    ) = viewModelScope.launch {
        _logoutResponse.value = Resource.Loading
        _logoutResponse.value = repository.logoutUser()
    }
}