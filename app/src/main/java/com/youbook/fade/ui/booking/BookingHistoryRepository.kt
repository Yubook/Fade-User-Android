package com.youbook.fade.ui.booking

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class BookingHistoryRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun getUserBookings(
    ) = safeApiCall {
        api.getUserBookings()
    }
}