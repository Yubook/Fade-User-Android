package com.youbook.fade.ui.appointment

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class AppointmentsRepository constructor(private val api : MyApi) : BaseRepository(){

    suspend fun getDriverSlots(
        driver_id: String?,
        date: String?,
        total_time: String?
    ) = safeApiCall {
        api.getDriverSlots(driver_id,date, total_time)
    }

    suspend fun rescheduleOrder(
        params: Map<String, String>
    ) = safeApiCall {
        api.rescheduleOrder(params)
    }
}