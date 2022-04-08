package com.android.main

import com.llj.baselib.IOTViewModel

class MainVM : IOTViewModel() {

    fun open() {
        sendOrderToDevice("A")
    }

    fun close() {
        sendOrderToDevice("B")
    }

}