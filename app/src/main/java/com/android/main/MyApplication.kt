package com.android.main

import android.app.Application
import com.llj.baselib.IOTLib
import com.llj.baselib.bean.UserConfigBean

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val bean = UserConfigBean(
            userId = "6895",
            appKey = "7e3130c485",
            deviceId = "15430",
            clientId = "766",
            clientSecret = "3702a74cd8"
        )
        IOTLib.init(applicationContext,bean)
    }
}