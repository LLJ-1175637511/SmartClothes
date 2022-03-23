package com.android.main

import android.app.Application
import com.llj.baselib.IOTLib
import com.llj.baselib.bean.UserConfigBean

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val bean = UserConfigBean(
            userId = "19231",
            appKey = "1a3bd6eb7c",
            deviceId = "25879",
            clientId = "1199",
            clientSecret = "b30377920b"
        )
        IOTLib.init(applicationContext,bean)
    }
}