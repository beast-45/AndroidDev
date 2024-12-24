package com.example.recyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var newsArrayList : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recycler)
        val newsImgArray = arrayOf(
            R.drawable.apple,
            R.drawable.bmw,
            R.drawable.chatgpt,
            R.drawable.google,
            R.drawable.meta,
            R.drawable.netflix,
            R.drawable.tesla,
            R.drawable.rr,
            R.drawable.mercedes,
            R.drawable.qcom,
            R.drawable.amd

        )
        val headlinearray = arrayOf(
            "Apple iPhone 17 Pro Design Saga Takes New Twist In Latest Report",
            "BMW’s R12 S Pays Homage To Perhaps The Most Famous BMW Motorcycle Ever",
            "Hyperscale Data Centers May Fundamentally Alter Global Power Demand",
            "Google’s Security Warning For 3 Billion Chrome Users—Update Now",
            "META Platforms stock is up 5% in a month, with investor optimism around the TikTok ban.",
            "Netflix brings star power to NFL Christmas games with national anthem performer reveal",
            "Xiaomi Unveils YU7 SUV As Rival To Tesla Model Y",
            "The Rolls-Royce riddle: When is a car brand not a car brand?",
            "‘We created history together’: Lewis Hamilton on writing one of F1’s greatest chapters with Mercedes",
            "Qualcomm secures key win in chips trial against Arm",
            "AMD Launches A YouTube Channel For Developers"

        )
        // layout manager is to set the properties of items inside RecyclerView like vertical scrolling ,horizontal scrolling
        recyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for(index in newsImgArray.indices)
        {
            val news = News(headlinearray[index] , newsImgArray[index])
            newsArrayList.add(news)
        }
        recyclerView.adapter = MyAdapter(newsArrayList , this)
    }
}