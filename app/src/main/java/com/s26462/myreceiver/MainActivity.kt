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
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {

    private lateinit var myReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myReceiver = MyReceiver()
        registerReceiver(myReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
//        startNotificationService()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myReceiver)
    }

    fun startNotificationService(){
        val intent = Intent(applicationContext,NotificationService::class.java)
        startService(intent)

    }
}