package com.example.notifications

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val notificationID = 0
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        createNotificationChannel()
    val notification = NotificationCompat.Builder(this , CHANNEL_ID)
        .setContentTitle("Notificatin App")
        .setContentText("Hey Manish Learn Android Development ASAPPPP")
        .setSmallIcon(R.drawable.apple)
        .setPriority(NotificationCompat.PRIORITY_MAX)
        .build()
        val notificationManager = NotificationManagerCompat.from(this)
        val notifBtn = findViewById<Button>(R.id.NotificationBTN)
        notifBtn.setOnClickListener {
            notificationManager.notify(notificationID,notification)
        }
    }

    private fun createNotificationChannel()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID , CHANNEL_NAME , NotificationManager.IMPORTANCE_DEFAULT).apply {
                  description =  "Hey Manish , You got this ! "
                  lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}