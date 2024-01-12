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

        val houseButton: ImageButton = findViewById(R.id.house_button)
        val paidButton: ImageButton = findViewById(R.id.paid_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val searchButton: ImageButton = findViewById(R.id.search_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)
        // val menuEvents: RecyclerView = findViewById(R.id.menu_events)

        val events = arrayListOf<Event>()

        events.add(Event(1, "cats", "Событие", "Просто событие", "Самое обычное событие"))

        /*menuEvents.layoutManager = LinearLayoutManager(this)
        menuEvents.adapter = EventsAdapter(events, this)*/

        menuButton.setOnClickListener {
            val intent = Intent(this, GroupsActivity::class.java)
            startActivity(intent)
        }

        paidButton.setOnClickListener {
            val intent = Intent(this, ColivingAuthActivity::class.java)
            startActivity(intent)
        }

        searchButton.setOnClickListener {
            val intent = Intent(this, BunActivity::class.java)
            startActivity(intent)
        }
    }
}