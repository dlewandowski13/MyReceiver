package com.s26462.myreceiver

import android.app.IntentService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(intent?.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)){
            Toast.makeText(context,"Tryb samolotowy", Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(context,NotificationService::class.java)
            context.startService(intent)
        }
    }
}