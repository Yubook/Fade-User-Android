package com.youbook.fade.ui.profile

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository
import okhttp3.MultipartBody

class ProfileRepository constructor(private val api : MyApi) : BaseRepository() {

    suspend fun addProfile(
        files: List<MultipartBody.Part>,
        params: Map<String,String>
    ) = safeApiCall {
        api.addProfile(files, params)
    }

    suspend fun updateProfileWithPhoto(
        files: List<MultipartBody.Part>,
        params: Map<String,String>
    ) = safeApiCall {
        api.updateProfile(files,params)
    }

    suspend fun updateProfileWithoutPhoto(
        params: Map<String,String>
    ) = safeApiCall {
        api.updateProfileWithoutPhoto(params)
    }

    suspend fun getStates(
        countryId:String
    ) = safeApiCall {
        api.getStates(countryId)
    }

    suspend fun getCities() = safeApiCall {
        api.getCities()
    }

}
