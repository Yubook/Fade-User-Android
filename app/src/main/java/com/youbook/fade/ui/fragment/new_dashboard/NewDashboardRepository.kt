package com.youbook.fade.ui.fragment.new_dashboard

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class NewDashboardRepository constructor(private val api : MyApi): BaseRepository() {

    suspend fun getDashBoardData(
        params: Map<String,String>
    ) = safeApiCall {
        api.getDashBoardData(params)
    }

    suspend fun getDashBoardDataWithOtherLatLon(
        params: Map<String,String>
    ) = safeApiCall {
        api.getDashBoardDataWithOtherLatLon(params)
    }

    suspend fun makeBarberFavUnFav(
        params: Map<String,String>
    ) = safeApiCall {
        api.makeBarberFavUnFav(params)
    }

    suspend fun getServices(
    ) = safeApiCall {
        api.getServices()
    }

}