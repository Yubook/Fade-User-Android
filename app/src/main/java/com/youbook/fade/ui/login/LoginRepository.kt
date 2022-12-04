package com.youbook.fade.ui.login

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class LoginRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun getCountryCode(
    ) = safeApiCall {
        api.getCountryCode()
    }
}