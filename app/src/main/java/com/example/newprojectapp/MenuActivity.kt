package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val newsButton: Button = findViewById(R.id.news_button)
        val colivingButton: ImageButton = findViewById(R.id.coliving_button)
        val groupsButton: ImageButton = findViewById(R.id.groups_button)
        val bunButton: ImageButton = findViewById(R.id.bun_button)
        val menuEvents: RecyclerView = findViewById(R.id.menu_events)

        val events = arrayListOf<Event>()

        events.add(Event(1, "cats", "Событие", "Просто событие", "Самое обычное событие"))

        menuEvents.layoutManager = LinearLayoutManager(this)
        menuEvents.adapter = EventsAdapter(events, this)

        groupsButton.setOnClickListener {
            val intent = Intent(this, GroupsActivity::class.java)
            startActivity(intent)
        }

        colivingButton.setOnClickListener {
            val intent = Intent(this, ColivingAuthActivity::class.java)
            startActivity(intent)
        }

        bunButton.setOnClickListener {
            val intent = Intent(this, BunActivity::class.java)
            startActivity(intent)
        }
    }
}