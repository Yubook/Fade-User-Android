package com.youbook.fade.ui.payment_history

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class PaymentHistoryRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun getUserPaymentHistory(
    ) = safeApiCall {
        api.getUserPaymentHistory()
    }
}
