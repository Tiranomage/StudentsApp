package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val houseButton: ImageButton = findViewById(R.id.house_button)
        val paidButton: ImageButton = findViewById(R.id.paid_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)
        val formButton: Button = findViewById(R.id.form_button)

        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        paidButton.setOnClickListener {
            val intent = Intent(this, PaidHousingActivity::class.java)
            startActivity(intent)
        }

        formButton.setOnClickListener {
            val intent = Intent(this, FormActivity::class.java)
            startActivity(intent)
            //TODO Добавить проверку на факт создания пользователем анкеты
        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        houseButton.setOnClickListener {
            val intent = Intent(this, HouseActivity::class.java)
            startActivity(intent)
        }
    }
}