package com.example.newprojectapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ScrollView

class FormActivity : AppCompatActivity() {

    private val scrollViewIds = arrayOf(
        R.id.scroll1,
        R.id.scroll2,
        R.id.scroll3,
        R.id.scroll4,
        R.id.scroll5,
        R.id.scroll6
    )

    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val userName: EditText = findViewById(R.id.edit_name)
        val userSocial: EditText = findViewById(R.id.edit_ref)
        val userDate: EditText = findViewById(R.id.user_birth_date)
        val backButton: ImageButton = findViewById(R.id.back_button_form)
        val forwardButton: ImageButton = findViewById(R.id.forward_button)
        val backwardButton: ImageButton = findViewById(R.id.backward_button)


        forwardButton.setOnClickListener {
            showNextScrollView()
        }

        backwardButton.setOnClickListener {
            showPreviousScrollView()
        }

        backButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showNextScrollView() {
        if (currentIndex < scrollViewIds.size - 1) {
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.INVISIBLE
            currentIndex++
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.VISIBLE
            if (currentIndex > 0)
                findViewById<ImageButton>(R.id.backward_button).visibility = View.VISIBLE
        }
        else if (currentIndex == 5) {
            val intent = Intent(this, NeighboursActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showPreviousScrollView() {
        if (currentIndex > 0) {
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.INVISIBLE
            currentIndex--
            findViewById<ScrollView>(scrollViewIds[currentIndex]).visibility = View.VISIBLE
            if (currentIndex == 0)
                findViewById<ImageButton>(R.id.backward_button).visibility = View.INVISIBLE
        }
    }
}