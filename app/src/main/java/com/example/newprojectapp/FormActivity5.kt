package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class FormActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form5)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val backwardButton: ImageButton = findViewById(R.id.backward_button)
        val forwardButton: ImageButton = findViewById(R.id.forward_button)


        forwardButton.setOnClickListener {
            val intent = Intent(this, FormActivity6::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        backwardButton.setOnClickListener {
            val intent = Intent(this, FormActivity4::class.java)
            startActivity(intent)
        }
    }
}