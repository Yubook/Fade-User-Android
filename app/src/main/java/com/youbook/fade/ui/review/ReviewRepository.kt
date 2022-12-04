package com.youbook.fade.ui.review

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class ReviewRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun getReview(
    ) = safeApiCall {
        api.getReview()
    }
}
