package com.petrux081.lifecycledemo

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val TAG = "LifecycleDemo"

    private var logText = ""

    private lateinit var tvContador: TextView
    private lateinit var btnIncrementar: Button
    private lateinit var btnDecrementar: Button
    private lateinit var btnReset: Button

    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializar views
        tvContador = findViewById(R.id.tvContador)
        btnIncrementar = findViewById(R.id.btnIncrementar)
        btnDecrementar = findViewById(R.id.btnDecrementar)
        btnReset = findViewById(R.id.btnReset)

        // Restaurar estado
        contador = savedInstanceState?.getInt("contador") ?: 0
        atualizarUI()

        // Listeners
        btnIncrementar.setOnClickListener {
            contador++
            atualizarUI()
            Log.d(TAG, "Incrementar")
        }

        btnDecrementar.setOnClickListener {
            contador--
            atualizarUI()
            Log.d(TAG, "Decrementar")

        }

        btnReset.setOnClickListener {
            contador = 0
            atualizarUI()
            Log.d(TAG, "Resetar")

        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("contador", contador)
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()

    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    private fun atualizarUI() {
        tvContador.text = contador.toString()
        tvContador.setTextColor(
            when {
                contador > 0 -> Color.GREEN
                contador < 0 -> Color.RED
                else -> Color.GRAY
            }
        )
    }


}