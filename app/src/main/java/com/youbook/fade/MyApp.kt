package com.youbook.fade

import android.app.Application
import com.youbook.fade.utils.Constants
import com.youbook.fade.utils.SocketConnector
import com.stripe.android.PaymentConfiguration

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SocketConnector.initSocket(this)

        PaymentConfiguration.init(
            applicationContext,
            Constants.PUBLISHABLE_URL
        )
    }
}