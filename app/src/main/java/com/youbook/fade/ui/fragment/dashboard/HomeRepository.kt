package com.youbook.fade.ui.fragment.dashboard

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class HomeRepository constructor(private val api : MyApi): BaseRepository() {

    suspend fun getOffer(
        params: Map<String,String>
    ) = safeApiCall {
        api.getDashBoardData(params)
    }

    suspend fun getNearestDrivers(
    ) = safeApiCall {
        api.getNearestDriver()
    }

    suspend fun searchDriver(
        params: Map<String,String>
    ) = safeApiCall {
        api.searchDriver(params)
    }
}