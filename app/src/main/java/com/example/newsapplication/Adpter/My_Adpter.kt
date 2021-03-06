package com.example.newsapplication.Adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapplication.MainActivity
import com.example.newsapplication.R
import com.example.newsapplication.View.ArticlesItem

class My_Adpter(val mainActivity: MainActivity, val list: List<ArticlesItem?>) :
    RecyclerView.Adapter<My_Adpter.ViewData>() {

    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img_news = itemView.findViewById<CardView>(R.id.img_news)
        var img_newscv = itemView.findViewById<ImageView>(R.id.img_newscv)
        var txt_title = itemView.findViewById<TextView>(R.id.txt_title)
        var txt_title_name = itemView.findViewById<TextView>(R.id.txt_title_name)
        var txt_subtitle = itemView.findViewById<TextView>(R.id.txt_subtitle)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        var view = LayoutInflater.from(mainActivity).inflate(R.layout.item, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var img = list[position]?.urlToImage

        holder.txt_subtitle.text = list[position]?.description
        Glide.with(mainActivity).load(img).centerCrop().into(holder.img_newscv)
        holder.txt_title.text=list[position]?.title
        holder.txt_title_name.text=list[position]?.source!!.name


    }

    override fun getItemCount(): Int {
        return list.size

    }
}

