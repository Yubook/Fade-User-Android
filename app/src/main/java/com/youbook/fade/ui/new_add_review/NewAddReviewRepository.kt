package com.youbook.fade.ui.new_add_review

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository
import okhttp3.MultipartBody

class NewAddReviewRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun makeBarberFavUnFav(
        params: Map<String,String>
    ) = safeApiCall {
        api.makeBarberFavUnFav(params)
    }

    suspend fun addReview(
        files: List<MultipartBody.Part>,
        params: Map<String, String>
    ) = safeApiCall {
        api.addReview(files,params)
    }

    suspend fun getDriverLatestLocation(
        orderId: String
    ) = safeApiCall {
        api.getDriverLatestLocation(orderId)
    }
}