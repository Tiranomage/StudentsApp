package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class PaidHousingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paid_housing)

        val houseButton: ImageButton = findViewById(R.id.house_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val searchButton: ImageButton = findViewById(R.id.search_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)
        val privateDormButton: ImageButton = findViewById(R.id.private_dorm_button)
        val paidHouseButton: ImageButton = findViewById(R.id.paid_house_button)
        val rentHouseButton: ImageButton = findViewById(R.id.rent_house_button)
        val buyHouseButton: ImageButton = findViewById(R.id.buy_house_button)

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

        paidHouseButton.setOnClickListener {
            val intent = Intent(this, PaidHouseActivity::class.java)
            startActivity(intent)
        }

        rentHouseButton.setOnClickListener {
            val intent = Intent(this, RentHouseActivity::class.java)
            startActivity(intent)
        }

        buyHouseButton.setOnClickListener {
            val intent = Intent(this, BuyActivity::class.java)
            startActivity(intent)
        }

        privateDormButton.setOnClickListener {
            val intent = Intent(this, PrivateDormActivity::class.java)
            startActivity(intent)
        }

        houseButton.setOnClickListener {
            val intent = Intent(this, HouseActivity::class.java)
            startActivity(intent)
        }
    }
}