package com.android.main

import android.Manifest
import com.android.main.databinding.ActivityLoginBinding
import com.llj.baselib.ui.IOTLoginActivity


class LoginActivity : IOTLoginActivity<ActivityLoginBinding>() {

    override fun getLayoutId() = R.layout.activity_login

    override fun initPermission() = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    override fun init() {
        super.init()
        mDataBinding.apply {
            etUserNameLogin.setText(getUserInfo().first)
            etUserPwdLogin.setText(getUserInfo().second)
            btLogin.setOnClickListener {
                login(etUserNameLogin.text.toString(),etUserPwdLogin.text.toString(), MainActivity::class.java)
            }
        }
    }

}