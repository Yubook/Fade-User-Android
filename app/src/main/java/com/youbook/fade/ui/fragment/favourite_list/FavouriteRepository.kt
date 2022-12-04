package com.youbook.fade.ui.fragment.favourite_list

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class FavouriteRepository constructor(private val api : MyApi): BaseRepository() {

    suspend fun getFavouriteBarber(
    ) = safeApiCall {
        api.getFavouriteBarbers()
    }

    suspend fun makeBarberFavUnFav(
        params: Map<String,String>
    ) = safeApiCall {
        api.makeBarberFavUnFav(params)
    }

}