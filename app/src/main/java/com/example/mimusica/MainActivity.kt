// El paquete: la carpeta donde vive este archivo. Debe ser igual al namespace del proyecto.
package com.example.mimusica

// Intent: el pedido para abrir otra pantalla.
import android.content.Intent
// Bundle: guarda el estado de la pantalla, por ejemplo al girar el teléfono.
import android.os.Bundle
// View: cualquier componente de la pantalla (botón, texto, campo).
import android.view.View
// enableEdgeToEdge: la pantalla usa todo el teléfono, hasta los bordes.
import androidx.activity.enableEdgeToEdge
// AppCompatActivity: la clase base de una pantalla de Android.
import androidx.appcompat.app.AppCompatActivity
// ViewCompat: herramientas para trabajar con los componentes.
import androidx.core.view.ViewCompat
// WindowInsetsCompat: mide las barras del sistema (hora, batería y botones).
import androidx.core.view.WindowInsetsCompat

// MainActivity es una pantalla: hereda todo lo que sabe hacer AppCompatActivity.
class MainActivity : AppCompatActivity() {
    // onCreate se ejecuta una vez, cuando se abre la pantalla.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Primero hace lo que Android hace siempre al crear una pantalla.
        super.onCreate(savedInstanceState)
        // Dibuja la pantalla detrás de las barras del sistema.
        enableEdgeToEdge()
        // Dibuja en esta pantalla el layout activity_main.xml (res/layout).
        setContentView(R.layout.activity_main)
        // Busca el componente con id main y espera a que Android mida las barras del sistema.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            // Toma el tamaño de la barra de arriba (hora, batería) y la de abajo (botones).
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Deja ese espacio como padding, para que las barras no tapen nada.
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            // Devuelve las medidas, por si otro componente las necesita.
            insets
        }
    }

    // Se ejecuta al tocar el botón que tiene android:onClick="IngresarOnClick" en su layout. view es el botón que se tocó.
    fun IngresarOnClick(view: View)
    {
        // Prepara el pedido: desde esta pantalla (this), abrir IAActivity.
        val intent = Intent(this, IAActivity::class.java)
        // Envía el pedido: se abre la pantalla nueva.
        startActivity(intent)
    }
}