package com.example.appstreaming

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstreaming.databinding.ActivityAccederBinding


class Acceder : AppCompatActivity() {

    private lateinit var binding: ActivityAccederBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccederBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cross.setOnClickListener {
            val intent = Intent(this@Acceder, MainActivity::class.java)
            startActivity(intent)
        }

        //cambiar backgroundTint de los editText al presionarlos
        binding.user.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.user.setBackgroundColor(Color.parseColor("#f47521"))
            } else {
                binding.user.setBackgroundColor(Color.parseColor("#57585a"))
            }
        }

    }



}