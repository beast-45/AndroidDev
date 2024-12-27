package com.example.apiapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MyAdapter (val context : Activity , val productArrayList : List<Product>) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView : View)  : RecyclerView.ViewHolder(itemView){
        var title : TextView
        var image : ShapeableImageView
        val des : TextView
        val price : TextView
        val rating : TextView

        init {
            title = itemView.findViewById(R.id.Name)
            image = itemView.findViewById(R.id.ProductImage)
            des = itemView.findViewById(R.id.Description)
            price = itemView.findViewById(R.id.price)
            rating = itemView.findViewById(R.id.rating)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.eachitem , parent , false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.des.text = currentItem.description
        holder.price.text = "$ "+currentItem.price.toString()
        holder.rating.text = "Rating : " + currentItem.rating.toString() + "/5"
        //how to show the image in image view if the image is in the form of a link or URL , 3rd party library
        //picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);

    }
}