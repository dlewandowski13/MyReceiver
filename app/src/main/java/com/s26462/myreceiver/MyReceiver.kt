package com.s26462.myreceiver

import android.app.IntentService
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.util.Log
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(intent?.action.equals("PRODUCT_ADDED")){
//            Log.e(TAG, "onReveive")
            Toast.makeText(context,"Broadcast Receiver", Toast.LENGTH_SHORT)
                .show()
            val message = intent.getStringExtra("message")
            val intentNotification = Intent(context,NotificationService::class.java)
                .putExtra("NotificationText",message)

            Log.e(TAG, message.toString())
            Toast.makeText(context,message ?: "message puste", Toast.LENGTH_SHORT)
                .show()

            context.startService(intentNotification)
        }
    }
}