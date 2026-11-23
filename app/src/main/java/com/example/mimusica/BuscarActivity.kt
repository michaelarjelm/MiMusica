package com.example.mimusica

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BuscarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_buscar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun btnBuscarOnClick(view: View) {
        val edtBusqueda = findViewById<EditText>(R.id.edtBusquedaBuscar)
        val spnTipo = findViewById<Spinner>(R.id.spnTipoBusqueda)
        val busqueda = edtBusqueda.text.toString().trim()
        val tipo = spnTipo.selectedItem.toString()

        if (busqueda.isEmpty()) {
            edtBusqueda.error = "Escribe qué quieres buscar"
            edtBusqueda.requestFocus()
            return
        }

        Toast.makeText(this, "$tipo: $busqueda", Toast.LENGTH_SHORT).show()
    }
}
