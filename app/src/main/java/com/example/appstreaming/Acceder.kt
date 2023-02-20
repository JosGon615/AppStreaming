package com.example.appstreaming

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.core.graphics.toColor
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

        //cambiar backgroundTint de los editText al hacer click
        binding.user.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.user.background.setTint(Color.parseColor("#24252a"))
            } else {
                binding.user.background.setTint(Color.parseColor("#57585a"))
            }
        }
        binding.pass.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.pass.background.setTint(Color.parseColor("#24252a"))

            } else {
                binding.pass.background.setTint(Color.parseColor("#57585a"))
            }
        }

       //mostrar icono drawable de ojo al hacer click




        textColor()



    }

    private fun textColor(){
        val spannableString1 = SpannableString("Al usar tu cuenta accedes a nuestros Términos y Política de Privacidad y confirmas que tienes 16 años o más.")
        val fcolor = ForegroundColorSpan(Color.parseColor("#f47521"))
        val fcolor2 = ForegroundColorSpan(Color.parseColor("#f47521"))
        spannableString1.setSpan(fcolor, 37, 45, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString1.setSpan(fcolor2, 48, 70, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.terminos.text = spannableString1

        val spannableString2 = SpannableString("¿Has olvidado tu contraseña?")
        spannableString2.setSpan(fcolor, 0, 28, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        val spannableString3 = SpannableString("Crear Cuenta")
        spannableString3.setSpan(fcolor, 0, 12, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)


        binding.olvidar.text = spannableString2
        binding.CrearC.text = spannableString3
    }

}