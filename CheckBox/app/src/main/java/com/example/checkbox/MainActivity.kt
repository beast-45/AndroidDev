package com.example.checkbox

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    companion object{
        const val key1 = "com.example.checkbox.key1name"
        const val key2 = "com.example.checkbox.key2pass"
    }
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

        binding.btn.setOnClickListener()
        {
            if(binding.checkboxx.isChecked)
            {
                val name =  binding.inputtxt1.text.toString()
                val pass = binding.inputtxt2.text.toString()
                val intent = Intent(this , welcome::class.java)
                intent.putExtra(key1 , name);
                intent.putExtra(key2 , pass);
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "Please agree to Terms and Conditions", Toast.LENGTH_SHORT).show()
            }
        }
    }
}