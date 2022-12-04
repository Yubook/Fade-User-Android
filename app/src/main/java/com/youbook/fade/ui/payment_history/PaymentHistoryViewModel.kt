package com.youbook.fade.ui.payment_history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.youbook.fade.network.Resource
import com.youbook.fade.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class PaymentHistoryViewModel constructor(private val repository: PaymentHistoryRepository) : BaseViewModel(repository){

    private val _userPaymentHistoryResponse: MutableLiveData<Resource<UserPaymentHistoryResponse>> = MutableLiveData()
    val userPaymentHistoryResponse: LiveData<Resource<UserPaymentHistoryResponse>>
        get() = _userPaymentHistoryResponse

    suspend fun getUserPaymentHistory(
    ) = viewModelScope.launch {
        _userPaymentHistoryResponse.value = Resource.Loading
        _userPaymentHistoryResponse.value = repository.getUserPaymentHistory()
    }
}

