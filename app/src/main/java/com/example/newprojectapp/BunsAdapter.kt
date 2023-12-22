package com.example.newprojectapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BunsAdapter(var buns: List<Bun>, var context: Context) : RecyclerView.Adapter<BunsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageButton = view.findViewById(R.id.bun_list_image)
        val title: TextView = view.findViewById(R.id.bun_list_title)
        val desc: TextView = view.findViewById(R.id.bun_list_desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bun_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return buns.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = buns[position].title
        holder.desc.text = buns[position].desc

        var imageId = context.resources.getIdentifier(
            buns[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)

        holder.image.setOnClickListener {
            val intent = Intent(context, EventDescActivity::class.java)

            intent.putExtra("bunImgId", imageId)
            intent.putExtra("bunTitle", buns[position].title)

            context.startActivity(intent)
        }
    }
}