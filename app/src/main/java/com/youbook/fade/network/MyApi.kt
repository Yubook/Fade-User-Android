package com.youbook.fade.network

import com.youbook.fade.ui.barber_details.BarberAvailableSlotsResponse
import com.youbook.fade.ui.barber_details.BarberDetailsResponseModel
import com.youbook.fade.ui.barber_details.ISFavouriteResponseModel
import com.youbook.fade.ui.fragment.booking_list.NewBookingListResponse
import com.youbook.fade.ui.fragment.dashboard.DriversResponse
import com.youbook.fade.ui.fragment.favourite_list.FavBarberResponseModel
import com.youbook.fade.ui.fragment.new_dashboard.NewDashBoardResponseModel
import com.youbook.fade.ui.fragment.new_dashboard.ServiceResponseModel
import com.youbook.fade.ui.login.CountryCodeResponseModel
import com.youbook.fade.ui.login_with_email.UserLoginResponse
import com.youbook.fade.ui.new_add_review.DriverLatestLocationResponseModel
import com.youbook.fade.ui.notification.NotificationListResponse
import com.youbook.fade.ui.payment_details.BookSlotsResponse
import com.youbook.fade.ui.payment_details.PaymentKeyResponse
import com.youbook.fade.ui.payment_details.StripePaymentResponse
import com.youbook.fade.ui.payment_history.UserPaymentHistoryResponse
import com.youbook.fade.ui.profile.CityResponse
import com.youbook.fade.ui.profile.ProfileResponse
import com.youbook.fade.ui.profile.StateResponse
import com.youbook.fade.ui.review.ReviewResponse
import com.youbook.fade.ui.select_service.ServicesResponse
import com.youbook.fade.ui.terms_privacy.TermsPrivacyResponse
import com.youbook.fade.utils.Constants
import com.google.gson.GsonBuilder
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.*

interface MyApi {

    @Multipart
    @POST("addProfile")
    suspend fun addProfile(
        @Part files: List<MultipartBody.Part>,
        @QueryMap params: Map<String, String>
    ): ProfileResponse

    @Multipart
    @POST("editProfile")
    suspend fun updateProfile(
        @Part files: List<MultipartBody.Part>,
        @QueryMap params: Map<String, String>
    ): ProfileResponse

    @FormUrlEncoded
    @POST("editProfile")
    suspend fun updateProfileWithoutPhoto(
        @FieldMap params: Map<String, String>
    ): ProfileResponse

    @GET("getStates")
    suspend fun getStates(@Query("country_id") country_id: String?): StateResponse

    @GET("getCities")
    suspend fun getCities(): CityResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("mobile") mobile: String,
        @Field("phone_code") phoneCode: String
    ): ProfileResponse

    @FormUrlEncoded
    @POST("loginUser")
    suspend fun loginUser(@Field("email") mobile: String): UserLoginResponse

    @FormUrlEncoded
    @POST("loginUserOtpVerify")
    suspend fun loginUserOtpVerify(
        @Field("email") mobile: String,
        @Field("otp") otp: Int
    ): ProfileResponse

    @FormUrlEncoded
    @POST("addDeviceIdAndToken")
    suspend fun getDashBoardData(
        @FieldMap params: Map<String, String>
    ): NewDashBoardResponseModel

    @FormUrlEncoded
    @POST("getNearByBarberByLocations")
    suspend fun getDashBoardDataWithOtherLatLon(
        @FieldMap params: Map<String, String>
    ): NewDashBoardResponseModel

    @FormUrlEncoded
    @POST("is_favourite")
    suspend fun makeBarberFavUnFav(
        @FieldMap params: Map<String, String>
    ): ISFavouriteResponseModel

    @GET("driverLatestLocation")
    suspend fun getDriverLatestLocation(
        @Query("order_id") forUser: String
    ): DriverLatestLocationResponseModel

    @FormUrlEncoded
    @POST("paymentProcess")
    suspend fun makePayment(
        @FieldMap params: Map<String, String>
    ): StripePaymentResponse


    @Multipart
    @POST("addReview")
    suspend fun addReview(
        @Part files: List<MultipartBody.Part>,
        @QueryMap params: Map<String, String>
    ): CommonResponse

    @Multipart
    @POST("addReview")
    suspend fun addReviewWithoutImage(
        @QueryMap params: Map<String, String>
    ): CommonResponse


    @FormUrlEncoded
    @POST("bookUserSlot")
    suspend fun bookUserSlot(
        @FieldMap params: Map<String, String>
    ): BookSlotsResponse

    @FormUrlEncoded
    @POST("bookUserSlotByWallet")
    suspend fun bookUserSlotByWallet(
        @FieldMap params: Map<String, String>
    ): CommonResponse

    @FormUrlEncoded
    @POST("rejectAndBookUserSlot")
    suspend fun rescheduleOrder(
        @FieldMap params: Map<String, String>
    ): CommonResponse

    @POST("logout")
    suspend fun logout(): CommonResponse

    @GET("getNearestDriver")
    suspend fun getNearestDriver(): DriversResponse

    @GET("getServices")
    suspend fun getServices(): ServiceResponseModel

    @GET("myFavouriteBarbers")
    suspend fun getFavouriteBarbers(): FavBarberResponseModel

    @GET("getCountries")
    suspend fun getCountryCode(): CountryCodeResponseModel

    @FormUrlEncoded
    @POST("searchDriver")
    suspend fun searchDriver(
        @FieldMap params: Map<String, String>
    ): DriversResponse

    @FormUrlEncoded
    @POST("bookAppointment")
    suspend fun bookAppointment(
        @FieldMap params: Map<String, String>,
        @Field("slot_ids[]") slotIdsList: ArrayList<String>,
        @Field("service_ids[]") serviceIds: ArrayList<String>
    ): CommonResponse

    @FormUrlEncoded
    @POST("checkBookAppointmentSlots")
    suspend fun getDriverSlots(
        @Field("barber_id") barber_id: String?,
        @Field("date") date: String?,
        @Field("total_time") total_time: String?
    ): BarberAvailableSlotsResponse

    @GET("getDriverProfile")
    suspend fun getBarberDetails(
        @Query("barber_id") driver_id: String?,
    ): BarberDetailsResponseModel

    @GET("getOrder")
    suspend fun getUserOrders(
        @Query("user_id") driver_id: String?
    ): NewBookingListResponse

    @GET("getUserBookings")
    suspend fun getUserBookings(): NewBookingListResponse

    @FormUrlEncoded
    @POST("cancelOrder")
    suspend fun orderCancelByUser(
        @FieldMap params: Map<String, String>
    ): CommonResponse

    @GET("getUserPaymentHistory")
    suspend fun getUserPaymentHistory(): UserPaymentHistoryResponse

    @GET("getReview")
    suspend fun getReview(): ReviewResponse

    @GET("getNotification")
    suspend fun getNotification(): NotificationListResponse

    @GET("read_notification")
    suspend fun readNotification(): CommonResponse

    @GET("getTermsPolicy")
    suspend fun getTermsPolicy(
        @Query("for") forUser: String
    ): TermsPrivacyResponse

    @GET("createPaymentToken")
    suspend fun getPaymentToken(): PaymentKeyResponse

    @GET("getService")
    suspend fun getService(): ServicesResponse


    companion object {

        var myApi: MyApi? = null

        fun getInstanceToken(authToken: String): MyApi {
            val client = OkHttpClient.Builder().apply {
                addInterceptor(AuthenticationInterceptor(authToken))
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }.build()

            val gson = GsonBuilder()
                .setLenient()
                .create()


            val retrofit = Retrofit.Builder()
            retrofit.baseUrl(Constants.BASE_URL)
            retrofit.client(client)
            retrofit.addConverterFactory(GsonConverterFactory.create(gson))
            retrofit.addConverterFactory(ScalarsConverterFactory.create())
            myApi = retrofit.build().create(MyApi::class.java)

            return myApi!!
        }

        fun getInstance(): MyApi {

            val client = OkHttpClient.Builder().apply {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }.build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

            if (myApi == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
                myApi = retrofit.create(MyApi::class.java)
            }
            return myApi!!
        }
    }

}