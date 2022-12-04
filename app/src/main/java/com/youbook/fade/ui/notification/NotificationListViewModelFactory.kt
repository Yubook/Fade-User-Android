package com.youbook.fade.ui.notification

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NotificationListViewModelFactory(private val paymentDetailsRepository: NotificationListRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotificationListViewModel(paymentDetailsRepository) as T
    }
}