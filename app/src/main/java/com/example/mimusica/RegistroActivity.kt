package com.example.mimusica

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun txtIrLoginOnClick(view: View)
    {
        finish()
    }

    fun btnCrearCuentaOnClick(view: View)
    {
        //region Variables
        val edtNombre = findViewById<EditText>(R.id.edtNombreRegistro)
        val edtCorreo = findViewById<EditText>(R.id.edtCorreoRegistro)
        val edtClave = findViewById<EditText>(R.id.edtClaveRegistro)
        val edtRepetirClave = findViewById<EditText>(R.id.edtRepetirClaveRegistro)
        val rgGenero = findViewById<RadioGroup>(R.id.rgGeneroRegistro)
        val chkTerminos = findViewById<CheckBox>(R.id.chkTerminosRegistro)
        val rbElegido = findViewById<RadioButton>(rgGenero.checkedRadioButtonId)

        val nombre = edtNombre.text.toString().trim()
        val correo = edtCorreo.text.toString().trim()
        val clave = edtClave.text.toString()
        val repetirClave = edtRepetirClave.text.toString()
        val genero = rbElegido.text.toString()
        //endregion

        //region validadores
        if (nombre.isEmpty()) {
            edtNombre.error = "Escribe tu nombre"
            edtNombre.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            edtCorreo.error = "El correo no es válido"
            edtCorreo.requestFocus()
            return
        }
        if (clave.length < 6) {
            edtClave.error = "Mínimo 6 caracteres"
            edtClave.requestFocus()
            return
        }

        if(clave!=repetirClave)
        {
            edtRepetirClave.error="Las contraseñas no coinciden"
            edtRepetirClave.requestFocus()
            return
        }
        if(!chkTerminos.isChecked)
        {
            Toast.makeText(this, "Debes aceptar los términos y condiciones", Toast.LENGTH_LONG).show()
        }

        Toast.makeText(this, "Cuenta creada $nombre. Te gusta $genero", Toast.LENGTH_LONG).show()

        finish()
        //endregion


    }
}
