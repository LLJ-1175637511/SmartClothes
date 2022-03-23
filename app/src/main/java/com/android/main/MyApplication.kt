package com.android.main

import android.app.Application
import com.llj.baselib.IOTLib
import com.llj.baselib.bean.UserConfigBean

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val bean = UserConfigBean(
            userId = "",
            appKey = "",
            deviceId = "",
            clientId = "",
            clientSecret = ""
        )
        IOTLib.init(applicationContext,bean)
    }
}