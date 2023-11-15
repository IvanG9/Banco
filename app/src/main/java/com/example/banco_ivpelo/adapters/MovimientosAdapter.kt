package com.example.banco_ivpelo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_ivpelo.R
import com.example.banco_ivpelo.databinding.ItemAccountBinding
import com.example.banco_ivpelo.databinding.ItemMovimientosBinding
import com.example.banco_ivpelo.pojo.Cuenta
import com.example.banco_ivpelo.pojo.Movimiento

class MovimientosAdapter (private val movimientos: ArrayList<*>?) : RecyclerView.Adapter<MovimientosAdapter.ViewHolder>()  {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_movimientos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movimientos?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (movimientos != null) {

            val movimiento: Movimiento = movimientos.get(position) as Movimiento

            with(holder) {
                //binding.tvOrder.text = cuenta.toString() Muestra todos los datos de la cuenta
                binding.textviewMovimientoDescripcion.text = movimiento.getDescripcion()
                binding.textViewMovimientoImporte.text = movimiento.getImporte().toString()
            }
        }

    }
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemMovimientosBinding.bind(view)
    }

}