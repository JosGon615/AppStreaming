package com.example.appstreaming

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import com.example.appstreaming.databinding.ActivityCrearCuentaBinding


class CrearCuenta : AppCompatActivity() {

    private lateinit var binding: ActivityCrearCuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textColor()

        binding.cross.setOnClickListener {
            val intent = Intent(this@CrearCuenta, MainActivity::class.java)
            startActivity(intent)
        }

        binding.Acceder.setOnClickListener {
            val intent = Intent(this@CrearCuenta, Acceder::class.java)
            startActivity(intent)
        }
    }

    private fun textColor(){
        val spannableString1 = SpannableString("Usando Crunchy accedes a nuestros Términos y Política de Privacidad y confirmas que tienes 16 años o más.")
        val fcolor = ForegroundColorSpan(Color.parseColor("#f47521"))
        val fcolor2 = ForegroundColorSpan(Color.parseColor("#f47521"))
        spannableString1.setSpan(fcolor, 34, 42, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString1.setSpan(fcolor2, 45, 67, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.terminos.text = spannableString1
    }

}