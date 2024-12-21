package com.example.checkbox

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.checkbox.databinding.ActivityWelcomeBinding

class welcome : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ActivityWelcomeBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val name =  intent.getStringExtra(MainActivity.key1)
        val password = intent.getStringExtra(MainActivity.key2)

        binding.nameText.setText("Welcome $name")
        binding.passText.setText("Your Password is : $password")
    }
}