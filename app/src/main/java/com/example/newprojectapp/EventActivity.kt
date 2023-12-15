package com.example.newprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        val eventsList: RecyclerView = findViewById(R.id.eventsList)
        val events = arrayListOf<Event>()

        events.add(Event(1, "cats", "Событие", "Просто событие", "Самое обычное событие"))
        events.add(Event(2, "cats", "Событие", "Просто событие", "Самое обычное событие"))
        events.add(Event(3, "cats", "Событие", "Просто событие", "Самое обычное событие"))

        eventsList.layoutManager = LinearLayoutManager(this)
        eventsList.adapter = EventsAdapter(events, this)
    }
}