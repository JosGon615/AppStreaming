package com.example.appstreaming

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AlertDialog
import com.example.appstreaming.databinding.ActivityCrearCuentaBinding
import com.google.firebase.auth.FirebaseAuth


class CrearCuenta : AppCompatActivity() {

    private lateinit var binding: ActivityCrearCuentaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCrearCuentaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textColor()

        //Botón para cerrar la ventana
        binding.cross.setOnClickListener {
            val intent = Intent(this@CrearCuenta, MainActivity::class.java)
            startActivity(intent)
        }

        //Botón para acceder a la ventana de inicio de sesión
        binding.Acceder.setOnClickListener {
            val intent = Intent(this@CrearCuenta, Acceder::class.java)
            startActivity(intent)
        }

        setup()
    }

    private fun textColor(){
        val spannableString1 = SpannableString("Usando Crunchy accedes a nuestros Términos y Política de Privacidad y confirmas que tienes 16 años o más.")
        val fcolor = ForegroundColorSpan(Color.parseColor("#f47521"))
        val fcolor2 = ForegroundColorSpan(Color.parseColor("#f47521"))
        spannableString1.setSpan(fcolor, 34, 42, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString1.setSpan(fcolor2, 45, 67, SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.terminos.text = spannableString1
    }

    //creacion de perfil de usuario mediante firebase
    private fun setup(){
        title = "Crear Cuenta"

        binding.crear.setOnClickListener(){
            val email = binding.user.text.toString()
            val password = binding.pass.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(){
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

    //acceder a la pantalla principal
    private fun showHome(email: String) {
        val homeIntent: Intent = Intent(this, MainActivity2::class.java).apply {
            putExtra("email", email)
        }
        startActivity(homeIntent)

    }

    //generar alerta si el usuario no se ha podido crear
    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error al autenticar al usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()

    }


}