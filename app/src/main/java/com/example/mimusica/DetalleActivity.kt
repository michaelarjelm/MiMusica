package com.example.mimusica

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cancion = intent.getStringExtra("cancion")
        val artista = intent.getStringExtra("artista")
        val txtCancion = findViewById<TextView>(R.id.txtCancionDetalle)
        val txtArtista= findViewById<TextView>(R.id.txtArtistaDetalle)
        txtCancion.text =cancion
        txtArtista.text = artista
    }

    fun btnEliminarOnClick(view: View)
    {
        Toast.makeText(this, "Canción eliminada", Toast.LENGTH_SHORT).show()
        finish()
    }
}