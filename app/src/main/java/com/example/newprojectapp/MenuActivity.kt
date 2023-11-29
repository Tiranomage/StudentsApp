package com.example.newprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val eventsList: RecyclerView = findViewById(R.id.eventsList)
        val events = arrayListOf<Event>()

        events.add(Event(1, "cats", "Бухич", "Просто бухич", "Самый обычный бухич"))
        events.add(Event(2, "cats", "Бухич", "Просто бухич", "Самый обычный бухич"))
        events.add(Event(3, "cats", "Бухич", "Просто бухич", "Самый обычный бухич"))

        eventsList.layoutManager = LinearLayoutManager(this)
        eventsList.adapter = EventsAdapter(events, this)
    }
}