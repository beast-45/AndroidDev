package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsArrayList: ArrayList<News> , var context : Activity):
RecyclerView.Adapter<MyAdapter.MyViewHolder>()
{
    // to create a new instance
    // when layout manager fails to find a view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row , parent , false)
        return MyViewHolder(itemView)
    }
    // Populates items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.headline
        holder.hImage.setImageResource(currentItem.newsImg)

    }
    //hoe many list items are present in the array

    override fun getItemCount(): Int {
        return newsArrayList.size

    }

    // it holds the view so that views are not created everytime , so memory can be saved
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hTitle  = itemView.findViewById<TextView>(R.id.HeadlineText)
        val hImage  = itemView.findViewById<ShapeableImageView>(R.id.HeadlineLogo)
    }

}
