package com.example.newsapplication

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.newsapplication.Fragment.categryfragment
import com.example.newsapplication.Fragment.homefragment
import com.example.newsapplication.View.ArticlesItem

class MainActivity : AppCompatActivity() {

    lateinit var btn: Button
    lateinit var homerv1: RelativeLayout
    lateinit var categeryrv2: RelativeLayout
    lateinit var userrv3: RelativeLayout
    lateinit var fragment_lay: FrameLayout

    var list = listOf<ArticlesItem?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        blinding()

        loadfragment(homefragment(this))
        homerv1.setOnClickListener {


            loadfragment(homefragment(this))
        }
        categeryrv2.setOnClickListener {

            loadfragment(categryfragment(this))
        }


    }


    fun blinding() {
        homerv1 = findViewById<RelativeLayout>(R.id.homerv1)
        fragment_lay = findViewById<FrameLayout>(R.id.fragment_lay)
        categeryrv2 = findViewById<RelativeLayout>(R.id.categeryrv2)
        userrv3 = findViewById<RelativeLayout>(R.id.userrv3)

    }

    fun loadfragment(fragment: Fragment) {
        var fragmentTransient = supportFragmentManager.beginTransaction()
        fragmentTransient.replace(R.id.fragment_lay, fragment)
        fragmentTransient.commit()
    }

}