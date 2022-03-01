package com.example.modul5lesson10.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson10.R
import com.example.modul5lesson10.model.Feed
import com.example.modul5lesson10.model.Story

class FeedAdapter(private var context: Context, private var items : ArrayList<Feed>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private val TYPE_ITEM_STORY = 0
        private val TYPE_ITEM_POST = 1
    }

    override fun getItemViewType(position: Int): Int {


        return if(items[position].stories.size > 0) TYPE_ITEM_STORY else TYPE_ITEM_POST
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_STORY){
            return StoryViewHolder(context, LayoutInflater.from(context).inflate(R.layout.item_feed_story, parent, false))
        }
        return PostViewHolder(LayoutInflater.from(context).inflate(R.layout.item_feed_post, parent, false))
    }

    private fun refreshAdapter(stories : ArrayList<Story>, rv : RecyclerView){
        rv.adapter = StoryAdapter(context, stories)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val feed = items[position]

        if(holder is StoryViewHolder){
            holder.apply {
                refreshAdapter(feed.stories, recyclerView)
            }
        }

        if(holder is PostViewHolder){
            holder.apply {
                iv_profile.setImageResource(feed.post!!.profileP)
                iv_photo.setImageResource(feed.post!!.photoP)
                tv_fullname.text = feed.post!!.fullnameP
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class StoryViewHolder(context: Context, view : View) : RecyclerView.ViewHolder(view){
        var recyclerView : RecyclerView

        init {
            recyclerView = view.findViewById(R.id.rv_story)
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class PostViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var iv_profile = view.findViewById<ImageView>(R.id.iv_profile_post)
        var iv_photo = view.findViewById<ImageView>(R.id.iv_photo_post)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname_post)
//        var like = view.findViewById<ImageView>(R.id.iv_like_post)
//        var like = view.findViewById<ImageView>(R.id.iv_comment_post)
//        var like = view.findViewById<ImageView>(R.id.iv_send_post)
//        var like = view.findViewById<ImageView>(R.id.iv_save_post)
    }
}