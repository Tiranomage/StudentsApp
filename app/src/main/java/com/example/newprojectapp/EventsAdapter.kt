package com.example.newprojectapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventsAdapter(var events: List<Event>, var context: Context) : RecyclerView.Adapter<EventsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.event_list_image)
        val title: TextView= view.findViewById(R.id.event_list_title)
        val desc: TextView = view.findViewById(R.id.event_list_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.event_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return events.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = events[position].title
        holder.desc.text = events[position].desc

        var imageId = context.resources.getIdentifier(
            events[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)
    }
}