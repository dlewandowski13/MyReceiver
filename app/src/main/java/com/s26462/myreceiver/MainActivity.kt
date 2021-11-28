package com.s26462.myreceiver

import android.Manifest
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.content.ComponentName
import android.content.ContentValues.TAG
import android.nfc.Tag
import android.util.Log
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {

    private lateinit var myReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myReceiver = MyReceiver()
        Log.e(TAG,"MyReceiver")
        registerReceiver(myReceiver, IntentFilter("PRODUCT_ADDED"))
//        registerReceiver(myReceiver, IntentFilter("PRODUCT_ADDED"), "MY_PERMISSION", null)
//        startNotificationService()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)
    }

}