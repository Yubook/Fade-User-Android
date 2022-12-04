package com.youbook.fade.ui.add_review

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository
import okhttp3.MultipartBody

class AddReviewRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun addReview(
        files: List<MultipartBody.Part>,
        params: Map<String, String>
    ) = safeApiCall {
        api.addReview(files,params)
    }

    suspend fun addReviewWithoutImage(
        params: Map<String, String>
    ) = safeApiCall {
        api.addReviewWithoutImage(params)
    }
}