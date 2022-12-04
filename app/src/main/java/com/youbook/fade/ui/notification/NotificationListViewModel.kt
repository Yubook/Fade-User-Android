package com.youbook.fade.ui.notification

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.youbook.fade.network.CommonResponse
import com.youbook.fade.network.Resource
import com.youbook.fade.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class NotificationListViewModel constructor(private val repository: NotificationListRepository) :
    BaseViewModel(repository) {

    private val _notificationListResponse: MutableLiveData<Resource<NotificationListResponse>> = MutableLiveData()
    val notificationListResponse: LiveData<Resource<NotificationListResponse>>
        get() = _notificationListResponse

    private val _readNotificationResponse: MutableLiveData<Resource<CommonResponse>> = MutableLiveData()
    val readNotificationResponse: LiveData<Resource<CommonResponse>>
        get() = _readNotificationResponse

    suspend fun getNotification(
    ) = viewModelScope.launch {
        _notificationListResponse.value = Resource.Loading
        _notificationListResponse.value = repository.getNotification()
    }

    suspend fun readNotification(
    ) = viewModelScope.launch {
        _readNotificationResponse.value = Resource.Loading
        _readNotificationResponse.value = repository.readNotification()
    }

}