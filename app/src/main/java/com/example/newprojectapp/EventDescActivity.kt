package com.example.newprojectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class EventDescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_desc)

        val image: ImageView = findViewById(R.id.event_cur_image)
        val title: TextView = findViewById(R.id.event_cur_title)
        val desc: TextView = findViewById(R.id.event_cur_desc)
        val imageId: Int = intent.getIntExtra("eventImgId", 0)

        image.setImageResource(imageId)
        title.text = intent.getStringExtra("eventTitle")
        desc.text = intent.getStringExtra("eventText")
    }
}