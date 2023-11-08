package com.example.banco_ivpelo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.banco_ivpelo.databinding.ActivityLoginBinding


// LoginActivity.kt
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val dniEditText =  binding.textNombreUsuario
        val passwordEditText = binding.textContrasenya
        val entrarButton = binding.btnLogin
        val salirButton = binding.btnExit

        entrarButton.setOnClickListener {
            val dni = dniEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (dni.isNotEmpty() && password.isNotEmpty()) {
                if (esValido(dni, password)) {
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("dniX", dni)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        salirButton.setOnClickListener {
            finish() // Salir de la aplicación
        }
    }

    private fun esValido(dni: String, password: String): Boolean {
        return dni == "12345678A" && password == "1234"
    }

}

// MainActivity.kt
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val dni = intent.getStringExtra("dni")
//
//        if (dni != null) {
//            val welcomeMessage = "Bienvenido/a, $dni"
//        }
//    }
//}