package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class FormActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form4)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val backwardButton: ImageButton = findViewById(R.id.backward_button)
        val forwardButton: ImageButton = findViewById(R.id.forward_button)


        forwardButton.setOnClickListener {
            val intent = Intent(this, FormActivity5::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        backwardButton.setOnClickListener {
            val intent = Intent(this, FormActivity3::class.java)
            startActivity(intent)
        }
    }
}