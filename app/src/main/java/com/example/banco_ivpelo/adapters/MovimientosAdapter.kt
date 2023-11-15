package com.example.banco_ivpelo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_ivpelo.R
import com.example.banco_ivpelo.databinding.ItemAccountBinding
import com.example.banco_ivpelo.pojo.Cuenta

class MovimientosAdapter (private val cuentas: ArrayList<*>?) : RecyclerView.Adapter<MovimientosAdapter.ViewHolder>()  {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_movimientos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cuentas?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (cuentas != null) {

            val cuenta: Cuenta = cuentas.get(position) as Cuenta

            with(holder) {
                //binding.tvOrder.text = cuenta.toString() Muestra todos los datos de la cuenta
                binding.textViewAccountName.text = cuenta.getNumeroCuenta()
                binding.textViewAccountBalance.text = cuenta.getSaldoActual().toString()
            }
        }

    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemAccountBinding.bind(view)
    }


}