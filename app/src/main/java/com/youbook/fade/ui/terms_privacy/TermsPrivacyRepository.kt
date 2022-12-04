package com.youbook.fade.ui.terms_privacy

import com.youbook.fade.network.MyApi
import com.youbook.fade.repository.BaseRepository

class TermsPrivacyRepository(private val api: MyApi) : BaseRepository() {

    // 3 = User
    suspend fun getTermsPolicy(
    ) = safeApiCall {
        api.getTermsPolicy("3")
    }

}