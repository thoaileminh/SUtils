package com.storm.utils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * @auth THOẠI ĐẠI CA
 * @date 20/04/2018
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         SUtils.hideSoftKeyboard(this)
    }
}