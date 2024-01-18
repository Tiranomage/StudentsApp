package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RadioButton

class HouseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_house)

        val paidButton: ImageButton = findViewById(R.id.paid_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val searchButton: ImageButton = findViewById(R.id.search_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)
        val paymentButton: ImageButton = findViewById(R.id.payment_button)
        val fireButton: ImageButton = findViewById(R.id.fire_button)
        val medicalButton: ImageButton = findViewById(R.id.medical_button)
        val rulesButton: ImageButton = findViewById(R.id.rules_button)
        val dormButton2: RadioButton = findViewById(R.id.button_dorm2)
        val dormButton4: RadioButton = findViewById(R.id.button_dorm4)
        val dormButton5: RadioButton = findViewById(R.id.button_dorm5)
        val dormButton6: RadioButton = findViewById(R.id.button_dorm6)
        val dormButton8: RadioButton = findViewById(R.id.button_dorm8)
        val dormButton10: RadioButton = findViewById(R.id.button_dorm10)
        val dormButton11: RadioButton = findViewById(R.id.button_dorm11)

        dormButton2.isChecked = true

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

        paymentButton.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            startActivity(intent)
        }

        fireButton.setOnClickListener {
            val intent = Intent(this, FireActivity::class.java)
            startActivity(intent)
        }

        medicalButton.setOnClickListener {
            val intent = Intent(this, MedicalActivity::class.java)
            startActivity(intent)
        }

        rulesButton.setOnClickListener {
            val intent = Intent(this,RulesActivity::class.java)
            startActivity(intent)
        }

        paidButton.setOnClickListener {
            val intent = Intent(this, PaidHousingActivity::class.java)
            startActivity(intent)
        }
    }
}