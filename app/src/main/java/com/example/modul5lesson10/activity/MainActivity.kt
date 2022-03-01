package com.example.modul5lesson10.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson10.R
import com.example.modul5lesson10.adapter.FeedAdapter
import com.example.modul5lesson10.model.Feed
import com.example.modul5lesson10.model.Post
import com.example.modul5lesson10.model.Story

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews(){
        recyclerView = findViewById(R.id.rv_main)
        recyclerView.layoutManager = GridLayoutManager(this, 1)

        refreshAdapter(getAllFeeds())
    }

    private fun refreshAdapter(feeds : ArrayList<Feed>){
        recyclerView.adapter = FeedAdapter(this, feeds)
    }

    private fun getAllFeeds() : ArrayList<Feed>{
        val stories : ArrayList<Story> = ArrayList()

        for(i in 0..6){
            stories.add(Story(R.drawable.img_profile, "Mansur$i"))
        }

        val feeds : ArrayList<Feed> = ArrayList()

        feeds.add(Feed(stories))

        for(i in 0..6){
            feeds.add(Feed(Post(R.drawable.img_profile, "Mansur$i", R.drawable.img_computer_3)))
        }

        return feeds
    }

}