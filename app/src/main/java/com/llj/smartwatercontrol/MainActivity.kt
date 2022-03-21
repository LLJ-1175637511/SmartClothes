package com.llj.smartwatercontrol

import androidx.activity.viewModels
import com.llj.baselib.IOTViewModel
import com.llj.baselib.ui.IOTMainActivity
import com.llj.smartwatercontrol.databinding.ActivityMainBinding

class MainActivity : IOTMainActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    private val vm by viewModels<MainVM>()

    override fun init() {
        super.init()
        vm.connect(this,MainDataBean::class.java)
    }

    override fun offline() {
        runOnUiThread {
            mDataBinding.tvDevState.text = "离线"
        }
    }

    override fun online() {
        runOnUiThread {
            mDataBinding.tvDevState.text = "在线"
        }
    }

    override fun realData(data: Any?) {
        TODO("Not yet implemented")
    }

    override fun webState(state: IOTViewModel.WebSocketType) {
        runOnUiThread {
            mDataBinding.tvState.text = state.name
        }
    }

}