package com.example.mimusica

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val canciones= listOf(
            Cancion("Fix You", "Coldplay", "Alternativa",12),
            Cancion("Tren al Sur", "Los Prisioneros", "Rock", 8),
            Cancion("Gracias a la Vida", "Violeta Parra", "Folclor", 5),
            Cancion("Cuando Pase el Temblor", "Soda Stereo", "Rock", 7),
            Cancion("Ojitos Lindos", "Bad Bunny", "Urbano", 20),
            Cancion("Flowers", "Miley Cyrus", "Pop", 3),
            Cancion("Déjate Caer", "Los Tres", "Rock", 4),
            Cancion("Vivir Mi Vida", "Marc Anthony", "Salsa", 9)
        )

        val rvCanciones = findViewById<RecyclerView>(R.id.rvCancionesLista)
        rvCanciones.layoutManager= LinearLayoutManager(this)
        rvCanciones.adapter= CancionAdapter(canciones)
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
}