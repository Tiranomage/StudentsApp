package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class UserProfileActivity : AppCompatActivity() {

    private lateinit var profileImage: ImageView
    private lateinit var refuseButton: ImageButton
    private lateinit var likeButton: ImageButton
    private lateinit var nameAgeText: TextView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        profileImage = findViewById(R.id.profileImage)
        refuseButton = findViewById(R.id.refuse_button)
        likeButton = findViewById(R.id.like_button)
        nameAgeText = findViewById(R.id.user_profile_title)
        progressBar = findViewById(R.id.progressBar)
        val houseButton: ImageButton = findViewById(R.id.house_button)
        val paidButton: ImageButton = findViewById(R.id.paid_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)
        val backButton: ImageButton = findViewById(R.id.back_button_user_profile)

        houseButton.setOnClickListener {
            val intent = Intent(this, HouseActivity::class.java)
            startActivity(intent)
        }

        paidButton.setOnClickListener {
            val intent = Intent(this, PaidHousingActivity::class.java)
            startActivity(intent)
        }

        menuButton.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, NeighboursActivity::class.java)
            startActivity(intent)
        }

        /*displayProfile(currentProfileIndex)

        profileButton.setOnClickListener {
            // Handle view profile action
            // You can navigate to a detailed profile activity or show a dialog
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        starButton.setOnClickListener {
            // Handle add to favorites action
            // Move to the next profile
            showNextProfile()
        }

        refuseButton.setOnClickListener {
            // Handle reject action
            // Move to the next profile
            showNextProfile()
        }*/

        /*profileImage.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }*/
    }
}