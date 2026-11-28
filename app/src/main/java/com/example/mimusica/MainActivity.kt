package com.example.mimusica

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun IngresarOnClick(view: View)
    {
        //region Variables
        val edtCorreo = findViewById<EditText>(R.id.edtCorreoLogin)
        val edtClave = findViewById<EditText>(R.id.edtClaveLogin)
        val correo = edtCorreo.text.toString()
        val clave = edtClave.text.toString()
        //endregion
        //region validaciones locales
        if(correo.isEmpty())
        {
            edtCorreo.error="Debes ingresar un correo"
            edtCorreo.requestFocus()
            return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches())
        {
            edtCorreo.error = "El correo no es válido"
            edtCorreo.requestFocus()
            return
        }
        if(clave.length<6)
        {
            edtClave.error = "La clave debe ser de mínimo 6 caracteres"
            edtClave.requestFocus()
            return
        }
        //endregion

        val auth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(correo, clave)
            .addOnCompleteListener(this) { entregado->
                if(entregado.isSuccessful)
                {
                    Toast.makeText(this, "Hola, $correo", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, ListaActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_LONG).show()
                }

            }

    }

    fun txtRegistroOnclick(view: View)
    {
        val intent = Intent(this, RegistroActivity::class.java)
        startActivity(intent)
    }
}