package com.example.mimusica

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun btnAgregarOnclick(view: View)
    {
        val intent = Intent(this, BuscarActivity::class.java)
        startActivity(intent)
    }

    fun btnIAOnClick(view: View)
    {
        val intent = Intent(this, IAActivity::class.java)
        startActivity(intent)
    }

    fun btnSalirOnClick(view: View)
    {
        finish()
    }

    fun filaOnClick(view: View)
    {
        val datos = view.tag.toString().split(";")
        val intent = Intent (this, DetalleActivity::class.java)
        intent.putExtra("cancion", datos[0])
        intent.putExtra("artista", datos[1])
        startActivity(intent)
    }
}