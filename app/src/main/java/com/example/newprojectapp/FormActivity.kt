package com.example.newprojectapp

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val userName: EditText = findViewById(R.id.edit_name)
        val userSocial: EditText = findViewById(R.id.edit_ref)
        val userDate: EditText = findViewById(R.id.user_birth_date)
        val backButton: ImageButton = findViewById(R.id.back_button_form)
        val forwardButton: ImageButton = findViewById(R.id.forward_button)


        forwardButton.setOnClickListener {
            val intent = Intent(this, FormActivity2::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }
    }
}