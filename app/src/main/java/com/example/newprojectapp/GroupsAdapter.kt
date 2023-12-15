package com.example.newprojectapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupsAdapter(var groups: List<Group>, var context: Context) : RecyclerView.Adapter<GroupsAdapter.MyViewHolder>() {

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.group_list_image)
        val title: TextView = view.findViewById(R.id.group_list_title)
        val desc: TextView = view.findViewById(R.id.group_list_desc)
        val btn: Button = view.findViewById(R.id.group_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.groups_in_list, parent, false)
        return GroupsAdapter.MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return groups.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = groups[position].title
        holder.desc.text = groups[position].desc

        var imageId = context.resources.getIdentifier(
            groups[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener {
            val intent = Intent(context, EventDescActivity::class.java)

            intent.putExtra("groupImgId", imageId)
            intent.putExtra("groupTitle", groups[position].title)

            context.startActivity(intent)
        }
    }
}