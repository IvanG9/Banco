package com.example.banco_ivpelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
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

        val opcionesMonedas = listOf(
            "€", "$"
        )


        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                binding.radioCuentaPropia.id -> {
                    binding.cmbCuentaDestino.visibility = View.VISIBLE
                    binding.editTextCuentaDestino.visibility = View.GONE
                    binding.textView3
                }

                binding.radioOtraOpcion.id -> {
                    binding.cmbCuentaDestino.visibility = View.GONE
                    binding.editTextCuentaDestino.visibility = View.VISIBLE
                }
            }
        }

        val adapterIban = ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesIBAN)
        val adapterMoneda =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, opcionesMonedas)

        adapterIban.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterMoneda.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.cmbOpciones3.adapter = adapterMoneda
        binding.cmbCuentaOrigen.adapter = adapterIban
        binding.cmbCuentaDestino.adapter = adapterIban

        binding.btnCancelar.setOnClickListener {
            binding.editTextCuentaDestino.text.clear()
            binding.editTextCantidad.text.clear()
            binding.checkboxJustificante.isChecked = false
        }

        binding.btnEnviar.setOnClickListener {
            val cuentaOrigen = binding.cmbCuentaOrigen.selectedItem.toString()
            var cuentaDestino = ""

            if (binding.radioCuentaPropia.isChecked) {
                cuentaDestino = binding.cmbCuentaOrigen.selectedItem.toString()
            } else {
                cuentaDestino = binding.editTextCuentaDestino.text.toString()
            }

            val moneda = binding.cmbOpciones3.selectedItem.toString()
            val enviarJustificante = binding.checkboxJustificante.isChecked
            val importe = binding.editTextCantidad.text.toString()

            val mensaje =
                "Cuenta Origen: $cuentaOrigen\nCuenta Destino: $cuentaDestino\nImporte: $importe $moneda\nEnviar Justificante: $enviarJustificante"

            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }


    }

}