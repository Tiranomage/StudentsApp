package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val houseButton: ImageButton = findViewById(R.id.house_button)
        val paidButton: ImageButton = findViewById(R.id.paid_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val searchButton: ImageButton = findViewById(R.id.search_button)
        val leaveButton: Button = findViewById(R.id.leave_button)

        menuButton.setOnClickListener {
            val intent = Intent(this, GroupsActivity::class.java)
            startActivity(intent)
        }

        paidButton.setOnClickListener {
            val intent = Intent(this, ColivingAuthActivity::class.java)
            startActivity(intent)
        }

        searchButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        leaveButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}