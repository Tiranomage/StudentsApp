package com.example.newprojectapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class FormActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form6)

        val backButton: ImageButton = findViewById(R.id.back_button)
        val backwardButton: ImageButton = findViewById(R.id.backward_button)
        val forwardButton: ImageButton = findViewById(R.id.forward_button)


        /*forwardButton.setOnClickListener {
            val intent = Intent(this, NeighboursActivity::class.java)
            startActivity(intent)
        }*/

        backButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        backwardButton.setOnClickListener {
            val intent = Intent(this, FormActivity5::class.java)
            startActivity(intent)
        }
    }
}