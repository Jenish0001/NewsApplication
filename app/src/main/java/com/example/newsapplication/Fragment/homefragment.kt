package com.example.newsapplication.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.newsapplication.Adpter.My_Adpter
import com.example.newsapplication.MainActivity
import com.example.newsapplication.R
import com.example.newsapplication.View.ApiClient
import com.example.newsapplication.View.ApiInterface
import com.example.newsapplication.View.ArticlesItem
import com.example.newsapplication.View.Newsmodel
import com.example.newsapplication.util.StsticFile.Companion.country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class homefragment(val mainActivity: MainActivity) : Fragment() {

    var list = listOf<ArticlesItem?>()
    lateinit var RvView: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_homefragment, container, false)
        RvView = view.findViewById<RecyclerView>(R.id.RvView)
        getNews(country, "business")
        rvSetUp()
        val helper: SnapHelper = LinearSnapHelper()
        helper.attachToRecyclerView(RvView)
        return view


    }

    fun rvSetUp() {

        var myAdpter = My_Adpter(mainActivity, list)
        var lm = LinearLayoutManager(mainActivity)
        RvView.adapter = myAdpter
        RvView.layoutManager = lm

    }

    fun getNews(country: String, category: String) {
        var apiInterface = ApiClient.getretrofit().create(ApiInterface::class.java)
        apiInterface.getNews(country, category, "9e41272f5ec1439c9a0692b57ca606ba")
            .enqueue(object : Callback<Newsmodel> {

                override fun onResponse(call: Call<Newsmodel>, response: Response<Newsmodel>) {
                    var newsModel = response.body()
                    list = newsModel?.articles!!

                    Log.e("TAG", "onResponse: ${response.body()}")
                    rvSetUp()
                }

                override fun onFailure(call: Call<Newsmodel>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }

            })

    }

}