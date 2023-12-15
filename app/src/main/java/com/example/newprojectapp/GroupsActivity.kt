package com.example.newprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)

        val groupList: RecyclerView = findViewById(R.id.groups_list)
        val groups = arrayListOf<Group>()

        groups.add(Group(1, "cats", "Изучение ///" , "1500 подписчиков"))
        groups.add(Group(2, "cats", "Изучение ///" , "1500 подписчиков"))
        groups.add(Group(3, "cats", "Изучение ///" , "1500 подписчиков"))

        groupList.layoutManager = GridLayoutManager(this, 2)
        groupList.adapter = GroupsAdapter(groups, this)
    }
}