package com.youbook.fade.ui.select_service

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class SelectServiceRepository (private val api : MyApi) : BaseRepository() {
    suspend fun getServices(
    ) = safeApiCall {
        api.getService()
    }
}