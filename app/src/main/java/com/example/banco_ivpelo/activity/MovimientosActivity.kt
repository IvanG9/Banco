package com.example.banco_ivpelo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_ivpelo.adapters.MovimientosAdapter
import com.example.banco_ivpelo.bd.MiBancoOperacional
import com.example.banco_ivpelo.databinding.ActivityMovimientosBinding
import com.example.banco_ivpelo.pojo.Cliente
import com.example.banco_ivpelo.pojo.Cuenta
import android.widget.ArrayAdapter

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
        val listaCuentas: ArrayList<Cuenta> = mbo?.getCuentas(cliente) as ArrayList<Cuenta>
        val listaMutable2: MutableList<String> = mutableListOf()

        for (cuenta in listaCuentas) {
            cuenta.getNumeroCuenta()?.let { numeroCuenta ->

                val segmento1 = numeroCuenta.substring(0, 4)
                val segmento2 = numeroCuenta.substring(4, 8)
                val segmento3 = numeroCuenta.substring(8, 10)
                val segmentoRestante = numeroCuenta.substring(10,numeroCuenta.length)

                val numeroFormateado = "$segmento1-$segmento2-$segmento3-$segmentoRestante"
                listaMutable2.add(numeroFormateado)

            }
        }

        val adapterIban = ArrayAdapter(this, android.R.layout.simple_spinner_item, listaMutable2)

        adapterIban.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.cmbCuenta.adapter = adapterIban

        linearLayoutManager = LinearLayoutManager(this)

        binding.cmbCuenta.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                movimientosAdapter = MovimientosAdapter(
                    mbo?.getMovimientos(
                        mbo.getCuentas(cliente)?.get(position) as Cuenta?
                    )
                )

                binding.recyclerView.apply {
                    layoutManager = linearLayoutManager
                    adapter = movimientosAdapter
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        })

    }
}


