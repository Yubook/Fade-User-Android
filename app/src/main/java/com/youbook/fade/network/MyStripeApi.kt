package com.youbook.fade.network
import com.youbook.fade.ui.payment_details.CardTokensResponse
import com.youbook.fade.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyStripeApi {

    @FormUrlEncoded
    @POST("tokens")
    suspend fun getCardTokens(
        @FieldMap params: Map<String, String>,
        @Header("Authorization") headerAuth : String
    ): CardTokensResponse

    companion object {

        var myApi: MyStripeApi? = null

        fun getInstance(): MyStripeApi {
            if (myApi == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL_STRIPE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                myApi = retrofit.create(MyStripeApi::class.java)
            }
            return myApi!!
        }


    }

}