package com.example.customizedlistview

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var userArrayList : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val name =  arrayOf("Saumya" , "Aksha" , "Manish" , "Sourav" , "Rahul" , "Saumya" , "Aksha" , "Manish" , "Sourav" , "Rahul")
        val lastMsg =  arrayOf("Hey" , "Hi" , "u up" , "Where are You?" , "Kahan h?" , "Hey" , "Hi" , "u up" , "Where are You?" , "Kahan h?")
        val lastMsgTime = arrayOf("11:45" , "11:11" , "11:11" , "23:11" , "14:08" , "11:45" , "11:11" , "11:11" , "23:11" , "14:08")
        val phoneNumber = arrayOf("9988776655" , "6988776655" , "9788776655" , "9988776655" ,"9988776655" , "9988776655" , "6988776655" , "9788776655" , "9988776655" ,"9988776655")
        val imgid = arrayOf(R.drawable.imgface1 , R.drawable.imgface2 , R.drawable.imgface3 , R.drawable.imgface7 , R.drawable.study , R.drawable.imgface1 , R.drawable.imgface2 , R.drawable.imgface3 , R.drawable.imgface7 , R.drawable.study)

        userArrayList = ArrayList()
        for(eachIndex in name.indices){
            val user = User(name[eachIndex] , lastMsg[eachIndex] , lastMsgTime[eachIndex] , phoneNumber[eachIndex] , imgid[eachIndex])
            userArrayList.add(user)
        }

        val listview =  findViewById<ListView>(R.id.LV)
        listview.isClickable =  true
        listview.adapter = myAdapter(this , userArrayList)

        listview.setOnItemClickListener { parent, view, position, id ->
            val uname = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgid[position]

            val i = Intent(this , UserActivity::class.java)
            i.putExtra("name" , uname)
            i.putExtra("Phone" , userPhone)
            i.putExtra("image" , imageId)

            startActivity(i)
        }

    }
}