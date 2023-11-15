package com.example.banco_ivpelo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.banco_ivpelo.bd.MiBancoOperacional
import com.example.banco_ivpelo.databinding.ActivityLoginBinding
import com.example.banco_ivpelo.pojo.Cliente


// LoginActivity.kt
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater);
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {


            val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)

            // Introducimos los datos como si fuera la pantalla inicial
            Log.e(this.componentName.className, "Creando el cliente a")
            var a = Cliente()
            a.setNif(binding.textNombreUsuario.text.toString())
            a.setClaveSeguridad(binding.textContrasenya.text.toString())

            // Logueamos al cliente
            val clienteLogeado = mbo?.login(a) ?: -1
            if (clienteLogeado == -1) {
                Toast.makeText(this, "El cliente no existe en la BD", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("Cliente", clienteLogeado)
                startActivity(intent)
            }

            /*
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
            */

        }

        binding.btnExit.setOnClickListener {
            finish() // Salir de la aplicación
        }
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