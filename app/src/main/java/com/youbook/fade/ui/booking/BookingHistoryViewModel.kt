package com.youbook.fade.ui.booking

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.youbook.fade.network.Resource
import com.youbook.fade.ui.base.BaseViewModel
import com.youbook.fade.ui.fragment.booking_list.NewBookingListResponse
import kotlinx.coroutines.launch

class BookingHistoryViewModel constructor(private val repository: BookingHistoryRepository) :
    BaseViewModel(repository) {
    private val _userOrderResponse: MutableLiveData<Resource<NewBookingListResponse>> = MutableLiveData()
    val userOrderResponse: LiveData<Resource<NewBookingListResponse>>
        get() = _userOrderResponse

    suspend fun getUserOrder(
    ) = viewModelScope.launch {
        _userOrderResponse.value = Resource.Loading
        _userOrderResponse.value = repository.getUserBookings()
    }
}