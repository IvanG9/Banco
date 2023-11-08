package com.example.banco_ivpelo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.banco_ivpelo.databinding.ActivityChangePassBinding

class ChangePassActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChangePassBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChangePassBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnExit.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }

}