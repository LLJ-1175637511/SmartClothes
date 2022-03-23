package com.android.main

import androidx.activity.viewModels
import com.android.main.databinding.ActivityMainBinding
import com.llj.baselib.IOTLib
import com.llj.baselib.IOTViewModel
import com.llj.baselib.ui.IOTMainActivity
import com.llj.baselib.utils.LogUtils
import com.llj.baselib.utils.ToastUtils

class MainActivity : IOTMainActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    private val vm by viewModels<MainVM>()

    override fun init() {
        super.init()
        vm.connect(this, MainDataBean::class.java)
        initMainView()
    }

    private fun initMainView() {

    }

    override fun offDevLine() {
        mDataBinding.tvDevState.text = "设备离线"
    }

    override fun onDevLine() {
        mDataBinding.tvDevState.text = "设备在线"
    }

    override fun realData(data: Any?) {
        ToastUtils.toastShort("data:${(data as MainDataBean).toString()}")
    }

    override fun webState(state: IOTViewModel.WebSocketType) {
        LogUtils.d(IOTLib.TAG,state.name.toString())
    }

}