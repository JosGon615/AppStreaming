package com.example.appstreaming

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.appstreaming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textColor()

    }
    private fun textColor(){
        val spannableString = SpannableString("o Crear Cuenta")
        val fcolor = ForegroundColorSpan(Color.parseColor("#f47521"))
        spannableString.setSpan(fcolor, 2, 14, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.crearCuenta.text = spannableString
    }


}