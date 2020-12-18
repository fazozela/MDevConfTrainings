package com.example.proyecto_41

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_speaker.*

class SpeakerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speaker)

        if(intent.extras != null){
            Glide.with(this).load(intent.getStringExtra("imgURL")).into(photo_view)
        }

    }
}