package com.example.newprojectapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class BuyRequestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_request)

        val houseButton: ImageButton = findViewById(R.id.house_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val searchButton: ImageButton = findViewById(R.id.search_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)
        val backButton: ImageButton = findViewById(R.id.back_button_buy_req)
        val buyReqButton: Button = findViewById(R.id.button_buy_req)

        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        searchButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }

        /*buyReqButton.setOnClickListener {

        }*/

    }
}