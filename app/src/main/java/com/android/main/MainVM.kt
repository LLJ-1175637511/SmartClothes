package com.android.main

import com.llj.baselib.IOTViewModel

class MainVM:IOTViewModel() {



    fun changeControl(){
        sendOrderToDevice("")
    }

}