package com.example.appstreaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstreaming.databinding.ActivityOlvidadoBinding

class Restablecer : AppCompatActivity() {

    private lateinit var binding: ActivityOlvidadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOlvidadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrow.setOnClickListener {
            val intent = Intent(this@Restablecer, Acceder::class.java)
            startActivity(intent)
        }
    }
}