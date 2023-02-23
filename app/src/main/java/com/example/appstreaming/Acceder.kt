package com.example.appstreaming

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AlertDialog
import com.example.appstreaming.databinding.ActivityAccederBinding
import com.google.firebase.auth.FirebaseAuth


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

        // Botón para crear una cuenta
        binding.CrearC.setOnClickListener {
            val intent = Intent(this@Acceder, CrearCuenta::class.java)
            startActivity(intent)
        }

        // Botón para restablecer la contraseña
        binding.olvidar.setOnClickListener {
            val intent = Intent(this@Acceder, Restablecer::class.java)
            startActivity(intent)
        }

        textColor()

        setup()

    }

    // Función para iniciar sesión
    private fun setup(){
        title = "Acceder"
        binding.acceder.setOnClickListener(){
            val email = binding.user.text.toString()
            val password = binding.pass.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(){
                    if(it.isSuccessful){
                        showHome(it.result?.user?.email ?: "")
                    }
                    else{
                        showAlert()
                    }
                }
            }
        }
    }

    // Función para mostrar un mensaje de error
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    // Función para mostrar la pantalla principal
    private fun showHome(email: String) {
        val homeIntent = Intent(this, MainActivity2::class.java).apply {
            putExtra("email", email)
        }
        startActivity(homeIntent)
    }

    // Cambiar el color de los textos
    private fun textColor(){
        val spannableString1 = SpannableString("Al usar tu cuenta accedes a nuestros Términos y Política de Privacidad y confirmas que tienes 16 años o más.")
        val fcolor = ForegroundColorSpan(Color.parseColor("#f47521"))
        val fcolor2 = ForegroundColorSpan(Color.parseColor("#f47521"))
        spannableString1.setSpan(fcolor, 37, 45, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString1.setSpan(fcolor2, 48, 70, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.terminos.text = spannableString1

    }

}