package com.example.banco_ivpelo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_ivpelo.adapters.AccountAdapter
import com.example.banco_ivpelo.bd.MiBancoOperacional
import com.example.banco_ivpelo.databinding.ActivityPosicionGlobalBinding
import com.example.banco_ivpelo.pojo.Cliente

class PosicionGlobalActivity : AppCompatActivity() {

    private lateinit var accountAdapter: AccountAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityPosicionGlobalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)

        binding = ActivityPosicionGlobalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cliente = intent.getSerializableExtra("Cliente") as? Cliente

        if (mbo != null) {
            accountAdapter = AccountAdapter(mbo.getCuentas(cliente))
        }
        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = accountAdapter
        }

    }
}

