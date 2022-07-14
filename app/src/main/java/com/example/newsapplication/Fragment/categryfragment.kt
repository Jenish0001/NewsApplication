package com.example.newsapplication.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.Adpter.My_Categery_Adpter
import com.example.newsapplication.MainActivity
import com.example.newsapplication.R
import com.example.newsapplication.View.ArticlesItem
import com.example.newsapplication.util.StsticFile.Companion.country


class categryfragment(val mainActivity: MainActivity) : Fragment() {

    var list = listOf<ArticlesItem>()
    var contryname = arrayOf(
        "us",
        "in",
        "ca",
        "au",
        "ma",
        "us",
        "in",
        "ca",
        "au",
        "ma",
        "us",
        "in",
        "ca",
        "au",
        "ma"
    )
//    var categery = arrayOf(
//        "General",
//        "sport",
//        "business",
//        "sport",
//        "business",
//        "General",
//        "sport",
//        "business",
//        "sport",
//        "business",
//        "General",
//        "sport",
//        "business",
//        "sport",
//        "business"
//    )

    lateinit var rvview: RecyclerView
    lateinit var ok_btn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_categryfragment, container, false)
        rvview = view.findViewById<RecyclerView>(R.id.rvview)
        ok_btn = view.findViewById<Button>(R.id.ok_btn)
        rvSetUp()

        ok_btn.setOnClickListener {


            Toast.makeText(mainActivity, "$country", Toast.LENGTH_SHORT).show()

//            var fragmentTransient = childFragmentManager.beginTransaction()
//            fragmentTransient.replace(R.id.fragment_lay,homefragment(mainActivity))
//            fragmentTransient.commit()
            val i = Intent(mainActivity, MainActivity::class.java)
            startActivity(i)
            activity?.finish()

        }
        return view

    }

    fun rvSetUp() {

        var myca = My_Categery_Adpter(activity, contryname)
        var lm = LinearLayoutManager(mainActivity)
        rvview.adapter = myca
        rvview.layoutManager = lm

    }

}