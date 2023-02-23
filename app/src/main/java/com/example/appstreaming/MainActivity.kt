package com.example.appstreaming

import android.content.Intent
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


        //al presionar los botones se abre la actividad correspondiente
        binding.explorar.setOnClickListener {
            val intent = Intent(this@MainActivity, Explorar::class.java)
            startActivity(intent)
        }
        binding.acceder.setOnClickListener {
            val intent = Intent(this@MainActivity, Acceder::class.java)
            startActivity(intent)
        }
        binding.crearCuenta.setOnClickListener {
            val intent = Intent(this@MainActivity, CrearCuenta::class.java)
            startActivity(intent)
        }

    }

    //funcion para cambiar el color de la palabra Crear Cuenta
    private fun textColor(){
        val spannableString = SpannableString("o Crear Cuenta")
        val fcolor = ForegroundColorSpan(Color.parseColor("#f47521"))
        spannableString.setSpan(fcolor, 2, 14, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.crearCuenta.text = spannableString
    }


}