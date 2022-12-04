package com.youbook.fade.ui.select_country

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository


class SelectCountryRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun getCountryCode() = safeApiCall {
        api.getCountryCode()
    }

}