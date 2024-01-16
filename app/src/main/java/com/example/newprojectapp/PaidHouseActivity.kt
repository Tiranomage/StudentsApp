package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import com.google.android.material.button.MaterialButtonToggleGroup

class PaidHouseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paid_house)

        val firstButton: Button = findViewById(R.id.firstButton)
        val secondButton: Button = findViewById(R.id.secondButton)
        val ovalImageView1: View = findViewById(R.id.button_fon_1)
        val ovalImageView2: View = findViewById(R.id.button_fon_2)
        val vkontakteScrollView: ScrollView = findViewById(R.id.scrollViewPosts)
        val textInfoScrollView: ScrollView = findViewById(R.id.scrollViewTextInfo)
        val buttonPay: Button = findViewById(R.id.button_pay)
        val backButton: ImageButton = findViewById(R.id.back_button_paid)
        val houseButton: ImageButton = findViewById(R.id.house_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val searchButton: ImageButton = findViewById(R.id.search_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)

        firstButton.isSelected = true
        secondButton.isSelected = false

        firstButton.setOnClickListener {
            firstButton.isSelected = true
            secondButton.isSelected = false
            ovalImageView1.visibility = View.VISIBLE
            ovalImageView2.visibility = View.INVISIBLE
            vkontakteScrollView.visibility = View.VISIBLE
            textInfoScrollView.visibility = View.INVISIBLE
        }

        secondButton.setOnClickListener {
            firstButton.isSelected = false
            secondButton.isSelected = true
            ovalImageView1.visibility = View.INVISIBLE
            ovalImageView2.visibility = View.VISIBLE
            vkontakteScrollView.visibility = View.INVISIBLE
            textInfoScrollView.visibility = View.VISIBLE
        }

        buttonPay.setOnClickListener {
            val intent = Intent(this, RequestActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, PaidHousingActivity::class.java)
            startActivity(intent)
        }

        menuButton.setOnClickListener {
            val intent = Intent(this, GroupsActivity::class.java)
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

    }


}