package com.example.modul5lesson10.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson10.R
import com.example.modul5lesson10.model.Story

class StoryAdapter(var context: Context, var items : ArrayList<Story>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StoryViewHolder(LayoutInflater.from(context).inflate(R.layout.item_story_view, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val story  = items[position]

        if(holder is StoryViewHolder){
            holder.apply {
                iv_profile.setImageResource(story.profileS)
                tv_fullname.text = story.fullnameS
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class StoryViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var iv_profile = view.findViewById<ImageView>(R.id.iv_profile_story)
        var tv_fullname = view.findViewById<TextView>(R.id.tv_fullname_story)
    }
}