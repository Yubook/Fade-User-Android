package com.youbook.fade.ui.fragment.booking_list

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class BookingListRepository constructor(private val api : MyApi): BaseRepository(){

    suspend fun getUserBookings(
    ) = safeApiCall {
        api.getUserBookings()
    }

    suspend fun orderCancelByUser(
        params:Map<String, String>
    ) = safeApiCall {
        api.orderCancelByUser(params)
    }

}
