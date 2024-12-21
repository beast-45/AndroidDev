package com.example.customizedlistview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class myAdapter (val context : Activity , val arrayList : ArrayList<User>) :
    ArrayAdapter<User>(context , R.layout.eachitem , arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view =  inflater.inflate(R.layout.eachitem , null)
        val image =  view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.Name)
        val lastmsg =  view.findViewById<TextView>(R.id.LastMessage)
        val lastMsgTime = view.findViewById<TextView>(R.id.Time)

        name.text = arrayList[position].name
        lastmsg.text = arrayList[position].LastMsg
        lastMsgTime.text = arrayList[position].LastMsgTime
        image.setImageResource(arrayList[position].ImgId)

        return view
    }
}