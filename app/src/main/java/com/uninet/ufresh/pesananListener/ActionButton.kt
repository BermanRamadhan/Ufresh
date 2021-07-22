package com.uninet.ufresh.pesananListener

import android.view.View

interface ActionButton {
    fun onClickActionButton(item:View,position : Int)
    fun onClickOpenDetail(item: View,position: Int)
}