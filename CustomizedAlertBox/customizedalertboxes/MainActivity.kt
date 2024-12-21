package com.example.customizedalertboxes

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.customizedalertboxes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    // Create a variable of type dialouge
    lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dialog = Dialog(this )
        dialog.setContentView(R.layout.custom_dialogbox)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alertboxbackground))

        binding.showBox.setOnClickListener()
        {
            dialog.show()
        }

        //Creating Variables for the custom dialog button
        val btngood =  dialog.findViewById<Button>(R.id.goodbtn)
        val feedbackbtn =  dialog.findViewById<Button>(R.id.feedbackbtn)

        btngood.setOnClickListener()
        {
            dialog.dismiss()
        }
        feedbackbtn.setOnClickListener()
        {
            Toast.makeText(this, "FEEDBACK SENT", Toast.LENGTH_SHORT).show()
        }
    }
}