package com.example.banco_ivpelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.banco_ivpelo.databinding.ActivityMain2Binding
import com.example.banco_ivpelo.databinding.ActivityTransferBinding

class TransferActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransferBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityTransferBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opcionesIBAN = listOf(
            "ES91-2100-0418-45-0200051332",
            "FR14-2004-1010-05-0500013M02606",
            "DE89-3704-0044-05-32013000",
            "IT60-X054-2811-10-1000000123456"
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

    }

}