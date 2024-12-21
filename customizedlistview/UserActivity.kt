package com.example.customizedlistview

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.intIntMapOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("Phone")
        val img = intent.getIntExtra("image" , R.drawable.study)

        val nametext = findViewById<TextView>(R.id.nameTV)
        val phonetext = findViewById<TextView>(R.id.phoneTV)
        val pImg = findViewById<CircleImageView>(R.id.pImg)

        nametext.text  = name
        phonetext.text = phone
        pImg.setImageResource(img)
    }
}