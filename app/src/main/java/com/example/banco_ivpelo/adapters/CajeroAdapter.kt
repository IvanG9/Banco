package com.example.banco_ivpelo.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_ivpelo.R
import com.example.banco_ivpelo.activity.OnClickListener
import com.example.banco_ivpelo.databinding.ItemCajeroBinding
import com.example.banco_ivpelo.entities.CajeroEntity

class CajeroAdapter(
    private var cajeros: MutableList<CajeroEntity>,
    private var listener: OnClickListener
) : RecyclerView.Adapter<CajeroAdapter.ViewHolder>() {


    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_cajero, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = cajeros.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cajero = cajeros[position]

        with(holder) {
            setListener(cajero)
            binding.textNombreCajero.text = "ATM ${cajero.id}"
            binding.textCajeroDireccion.text = cajero.direccion
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemCajeroBinding.bind(view)

        fun setListener(cajero: CajeroEntity) {
            binding.root.setOnClickListener {
                listener.onClick(cajero)
            }
        }

    }
}