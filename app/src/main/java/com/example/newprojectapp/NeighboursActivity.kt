package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class NeighboursActivity : AppCompatActivity() {

    private lateinit var profileButton: ImageButton
    private lateinit var starButton: ImageButton
    private lateinit var profileImage: ImageView
    private lateinit var refuseButton: ImageButton
    private lateinit var likeButton: ImageButton
    private lateinit var nameAgeText: TextView
    private lateinit var progressBar: ProgressBar

    private var currentProfileIndex = 0
    /*private val profilesList = getProfilesFromDatabase()*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neighbours)

        profileButton = findViewById(R.id.profile_button)
        starButton = findViewById(R.id.star_button)
        profileImage = findViewById(R.id.profileImage)
        refuseButton = findViewById(R.id.refuse_button)
        likeButton = findViewById(R.id.like_button)
        nameAgeText = findViewById(R.id.name_age_text)
        progressBar = findViewById(R.id.progressBar)
        val houseButton: ImageButton = findViewById(R.id.house_button)
        val paidButton: ImageButton = findViewById(R.id.paid_button)
        val menuButton: ImageButton = findViewById(R.id.menu_button)
        val settingsButton: ImageButton = findViewById(R.id.settings_button)

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
    /*private fun showNextProfile() {
        currentProfileIndex++
        if (currentProfileIndex < profilesList.size) {
            displayProfile(currentProfileIndex)
        } else {
            // You have reached the end of profiles, handle as needed (e.g., show a message)
            // Optionally, you can loop back to the first profile or implement other logic
        }
    }*/

    /*private fun displayProfile(index: Int) {
        val profile = profilesList[index]
        nameAgeText.text = "${profile.name}, ${profile.age}"
        profileImage.setImageResource(profile.imageResourceId)
        // Update other profile details and progress bar based on your data model
        progressBar.progress = profile.interestsPercentage
    }*/

    /*private fun getProfilesFromDatabase(): List<Profile> {
        // Replace with your database interaction logic to fetch profiles
        // For simplicity, using dummy data
        return listOf(
            Profile("User 1", 25, "LA", R.drawable.profile_image_1, 70),
            Profile("User 2", 28, "NYC", R.drawable.profile_image_2, 50),
            // Add more profiles as needed
        )
    }*/
}