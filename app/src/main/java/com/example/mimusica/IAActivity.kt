package com.example.mimusica

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class IAActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun btnVolverOnClick(view: View)
    {
        finish()
    }

    fun btnGenerarOnClick(view: View)
    {
        val edtAnimo = findViewById<EditText>(R.id.edtAnimoIA)
        val txtRespuesta = findViewById<TextView>(R.id.txtRespuestaIA)
        val animo = edtAnimo.text.toString().trim()

        if(animo.isEmpty())
        {
            edtAnimo.error = "Coméntanos como te sientes"
            edtAnimo.requestFocus()
            return
        }

        txtRespuesta.text = "Buscando canciones para: $animo"
    }
}
