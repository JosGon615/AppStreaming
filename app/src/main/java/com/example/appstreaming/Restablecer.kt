package com.example.appstreaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.appstreaming.databinding.ActivityRestablecerBinding

class Restablecer : AppCompatActivity() {

    private lateinit var binding: ActivityRestablecerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestablecerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrow.setOnClickListener {
            val intent = Intent(this@Restablecer, Acceder::class.java)
            startActivity(intent)
        }
    }
}