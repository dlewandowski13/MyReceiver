package com.s26462.myreceiver

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_MUTABLE
import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import android.content.ComponentName




class NotificationService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        Toast.makeText(this,"service", Toast.LENGTH_SHORT).show()
        createNotificationChannel()
//      Intent do przekierowywania do tej apliakacji
//        val notificationIntent = Intent(this, MainActivity::class.java)
//        Toast.makeText(this,"notificationIntent $notificationIntent", Toast.LENGTH_LONG).show()
//      Przekierowanie do ShoppingList
        val  newIntent = Intent()
        newIntent.component = ComponentName("com.s26462.shoppinglist", "com.s26462.shoppinglist.ShoppingList")
//        Log.e(TAG,"Intent + ${newIntent}")
//        Toast.makeText(this,"newIntent $newIntent", Toast.LENGTH_LONG)
//            .show()
//        val notificationIntent = this.packageManager?.getLaunchIntentForPackage("com.s26462.shoppinglist.Shoppinglist")
//        val pendingIntent = PendingIntent.getActivity(this,0,notificationIntent,FLAG_MUTABLE)
        val pendingIntent = PendingIntent.getActivity(baseContext,0,newIntent,0)
        val message = intent?.getStringExtra("NotificationText")

        val notification = NotificationCompat.Builder(this,getString(R.string.channelID))
            .setContentTitle(getText(R.string.notification_title))
            .setContentText(message ?: getText(R.string.notification_text))
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentIntent(pendingIntent)
            .build()

            startForeground(1,notification)


        return START_NOT_STICKY
    }

    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.O)
            return
        // SDK >= 26
        val notificationChannel = NotificationChannel(
            getString(R.string.channelID),
            getString(R.string.channel_name),
            NotificationManager.IMPORTANCE_DEFAULT
        )
        notificationChannel.description =
            getString(R.string.channel_description)
        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.createNotificationChannel(notificationChannel)
    }


    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}