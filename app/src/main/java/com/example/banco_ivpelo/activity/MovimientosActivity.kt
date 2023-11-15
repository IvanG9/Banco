package com.example.banco_ivpelo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_ivpelo.adapters.MovimientosAdapter
import com.example.banco_ivpelo.bd.MiBancoOperacional
import com.example.banco_ivpelo.databinding.ActivityMovimientosBinding
import com.example.banco_ivpelo.pojo.Cliente
import com.example.banco_ivpelo.pojo.Cuenta

class MovimientosActivity : AppCompatActivity() {


    private lateinit var movimientosAdapter: MovimientosAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var binding: ActivityMovimientosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mbo: MiBancoOperacional? = MiBancoOperacional.getInstance(this)

        binding = ActivityMovimientosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cliente = intent.getSerializableExtra("Cliente") as? Cliente

        if (mbo != null) {
            movimientosAdapter = MovimientosAdapter(mbo.getMovimientos(mbo.getCuentas(cliente)?.get(0) as Cuenta?))
        }

        linearLayoutManager = LinearLayoutManager(this)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = movimientosAdapter
        }

    }
}
