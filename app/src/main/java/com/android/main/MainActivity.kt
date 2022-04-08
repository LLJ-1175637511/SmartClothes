package com.android.main

import android.annotation.SuppressLint
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.android.main.databinding.ActivityMainBinding
import com.llj.baselib.IOTLib
import com.llj.baselib.IOTViewModel
import com.llj.baselib.ui.IOTMainActivity
import com.llj.baselib.utils.LogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : IOTMainActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    private val vm by viewModels<MainVM>()

    override fun init() {
        super.init()
        vm.connect(this, MainDataBean::class.java)
        initMainView()
    }

    private fun initMainView() {
        initToolbar()
        lifecycleScope.launch(Dispatchers.IO) {
            while (true) {
                runOnUiThread {
                    mDataBinding.tvTips.text = tips[(0..tips.lastIndex).random()]
                }
                delay(5000)
            }
        }
        mDataBinding.boxShake.setOnCheckedChangeListener { _, b ->
            if (mDataBinding.tvDevState.text != "设备在线") return@setOnCheckedChangeListener
            if (b) vm.open()
            else vm.close()
        }
    }

    private fun initToolbar() {
        mDataBinding.toolbar.apply {
            toolbarBaseTitle.text = getString(R.string.app_name)
            toolbarBase.inflateMenu(R.menu.toolbar_menu)
            toolbarBase.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.quit_app -> {
                        startCommonActivity<LoginActivity>()
                        finish()
                    }
                }
                false
            }
        }
    }

    private val tips = arrayOf(
        "今日天气不错 记得多通通风呦！",
        "上班前 不要忘记关闭无用电源哦！",
        "出门在外 要一个人照顾好自己哦！",
        "新的一天 要元气满满呀"
    )

    @SuppressLint("ResourceAsColor")
    override fun offDevLine() {
        mDataBinding.tvDevState.setTextColor(R.color.red)
        mDataBinding.tvDevState.text = "设备离线"
    }

    @SuppressLint("ResourceAsColor")
    override fun onDevLine() {
        mDataBinding.tvDevState.setTextColor(R.color.greenDark)
        mDataBinding.tvDevState.text = "设备在线"
    }

    @SuppressLint("SetTextI18n")
    override fun realData(data: Any?) {
        if (data == null) return
        val mainDataBean = data as MainDataBean
        mDataBinding.tvTemp.text = "${mainDataBean.temp.toShow()} °c"
        mDataBinding.tvHump.text = "${mainDataBean.humi.toShow()} %"
        mDataBinding.tvWind.text = "${mainDataBean.windDegree.toShow()} m/s"
        if (mainDataBean.windDegree > 200){
            mDataBinding.tvLight.text = "不足"
        }else{
            mDataBinding.tvLight.text = "良好"
        }
        if (mainDataBean.covered == 1){
            mDataBinding.tvCover.text = "有衣物"
        }else{
            mDataBinding.tvCover.text = "无衣物"
        }
        if (mainDataBean.rained > 800f){
            mDataBinding.tvRain.text = "晴朗"
        }else{
            mDataBinding.tvRain.text = "有雨"
        }
//        ToastUtils.toastShort("data:${(data as MainDataBean).toString()}")
    }

    override fun webState(state: IOTViewModel.WebSocketType) {
        LogUtils.d(IOTLib.TAG, state.name.toString())
    }

    fun Float.toShow() = ((this * 10).toInt() / 10).toString()
}