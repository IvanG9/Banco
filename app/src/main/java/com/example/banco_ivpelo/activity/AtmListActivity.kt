package com.example.banco_ivpelo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.banco_ivpelo.R
import com.example.banco_ivpelo.adapters.CajeroAdapter
import com.example.banco_ivpelo.databinding.ActivityAtmListBinding
import com.example.banco_ivpelo.entities.CajeroEntity
import java.util.Objects

class AtmListActivity : AppCompatActivity(), OnClickListener {
    private lateinit var binding: ActivityAtmListBinding
    private lateinit var mAdapter: CajeroAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAtmListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        mAdapter = CajeroAdapter(mutableListOf(), this)
        mGridLayout = GridLayoutManager(this, 1)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    override fun onClick(obj: Any?) {

    }

}