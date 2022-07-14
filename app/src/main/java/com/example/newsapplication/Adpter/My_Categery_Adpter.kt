package com.example.newsapplication.Adpter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.Fragment.categryfragment
import com.example.newsapplication.R
import com.example.newsapplication.util.StsticFile.Companion.country

var list =    arrayListOf<Int>(R.color.white, R.color.white, R.color.white, R.color.white, R.color.white,R.color.white, R.color.white, R.color.white, R.color.white, R.color.white,R.color.white, R.color.white, R.color.white, R.color.white, R.color.white)
var list1 =    arrayListOf<Int>(R.color.black, R.color.black, R.color.black, R.color.black, R.color.black,R.color.black, R.color.black, R.color.black, R.color.black, R.color.black,R.color.black, R.color.black, R.color.black, R.color.black, R.color.black)

class My_Categery_Adpter(
    val mainActivity: FragmentActivity?,
//    val categery: Array<String>,
    var contryname: Array<String>,
) : RecyclerView.Adapter<My_Categery_Adpter.ViewData>() {


    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textcardview = itemView.findViewById<TextView>(R.id.textcardview)
//        var textcategryname = itemView.findViewById<TextView>(R.id.textcategryname)
        var cv1 = itemView.findViewById<CardView>(R.id.cv1)
//        var cv2 = itemView.findViewById<CardView>(R.id.cv2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {


        var view = LayoutInflater.from(mainActivity).inflate(R.layout.item_categry, parent,false)

        return ViewData(view)

    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var i: Int = 0
        holder.cv1.setCardBackgroundColor(mainActivity!!.getColor(list[position]))
        holder.textcardview.setTextColor(
            mainActivity!!.getColor(list1[position]),
        )

        holder.textcardview.text = contryname[position]
//        holder.textcategryname.text = categery[position]


        holder.cv1.setOnClickListener {
            country=contryname[position]
//            country=
            list[position] = R.color.black;
            list1[position] = R.color.white;
                holder.cv1.setCardBackgroundColor(mainActivity!!.getColor(list[position]),)
                holder.textcardview.setTextColor(mainActivity!!.getColor(list1[position]),)
            while (i< list.size)
            {
                if(i!=position)
                {
                    list[i] = R.color.white
                    list1[i]=R.color.black
                }
                i++
            }
            notifyDataSetChanged()
//            Toast.makeText(mainActivity, "${contryname[position]}", Toast.LENGTH_SHORT).show()

        }

//        holder.ok_btn.setOnClickListener {
//
//
//        }
    }

    override fun getItemCount(): Int {

        return contryname.size
    }

}