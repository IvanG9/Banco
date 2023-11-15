package com.example.banco_ivpelo.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banco_ivpelo.databinding.ActivityMain2Binding
import com.example.banco_ivpelo.pojo.Cliente


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val cliente = intent.getSerializableExtra("Cliente") as? Cliente
        if (cliente != null) {
            binding.bienvenida.text = "Bienvenido/a ${cliente.getNombre()}"
        }

        binding.btnPosicionGlobal.setOnClickListener {
            val intent = Intent(this, PosicionGlobalActivity::class.java)
            intent.putExtra("Cliente", cliente)
            startActivity(intent)
        }

        binding.btnTransferencias.setOnClickListener {
            val intent = Intent(this, TransferActivity::class.java)
            startActivity(intent)
        }


        binding.btnCambiarContrasenya.setOnClickListener {
            val intent = Intent(this, ChangePassActivity::class.java)
            startActivity(intent)
        }

        binding.btnSalir.setOnClickListener {
            finish()
        }

    }

}