package com.youbook.fade.ui.notification

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class NotificationListRepository(private val api: MyApi) : BaseRepository() {

    suspend fun getNotification(
    ) = safeApiCall {
        api.getNotification()
    }

    suspend fun readNotification(
    ) = safeApiCall {
        api.readNotification()
    }

}