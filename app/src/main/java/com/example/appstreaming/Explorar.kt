package com.example.appstreaming

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstreaming.databinding.ActivityExplorarBinding


class Explorar : AppCompatActivity() {
    private lateinit var binding: ActivityExplorarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplorarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cross.setOnClickListener {
            val intent = Intent(this@Explorar, MainActivity::class.java)
            startActivity(intent)
        }
    }
}