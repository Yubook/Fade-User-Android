package com.youbook.fade.ui.login_with_email

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class EmailLoginRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun getCountryCode(
    ) = safeApiCall {
        api.getCountryCode()
    }

    suspend fun loginUser(
        email: String
    ) = safeApiCall {
        api.loginUser(email)
    }
}