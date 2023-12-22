package com.example.newprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class BunActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bun)

        val bunList: RecyclerView = findViewById(R.id.buns_list)
        val buns = arrayListOf<Bun>()

        buns.add(Bun(1, "cats", "Скидка 10% на поезд" , "Описание"))
        buns.add(Bun(1, "cats", "Скидка 10% на поезд" , "Описание"))
        buns.add(Bun(1, "cats", "Скидка 10% на поезд" , "Описание"))

        bunList.layoutManager = GridLayoutManager(this, 1)
        bunList.adapter = BunsAdapter(buns, this)
    }
}