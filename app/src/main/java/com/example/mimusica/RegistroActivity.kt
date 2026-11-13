// El paquete: la carpeta donde vive este archivo. Debe ser igual al namespace del proyecto.
package com.example.mimusica

// Bundle: guarda el estado de la pantalla, por ejemplo al girar el teléfono.
import android.os.Bundle
// enableEdgeToEdge: la pantalla usa todo el teléfono, hasta los bordes.
import androidx.activity.enableEdgeToEdge
// AppCompatActivity: la clase base de una pantalla de Android.
import androidx.appcompat.app.AppCompatActivity
// ViewCompat: herramientas para trabajar con los componentes.
import androidx.core.view.ViewCompat
// WindowInsetsCompat: mide las barras del sistema (hora, batería y botones).
import androidx.core.view.WindowInsetsCompat

// RegistroActivity es una pantalla: hereda todo lo que sabe hacer AppCompatActivity.
class RegistroActivity : AppCompatActivity() {
    // onCreate se ejecuta una vez, cuando se abre la pantalla.
    override fun onCreate(savedInstanceState: Bundle?) {
        // Primero hace lo que Android hace siempre al crear una pantalla.
        super.onCreate(savedInstanceState)
        // Dibuja la pantalla detrás de las barras del sistema.
        enableEdgeToEdge()
        // Dibuja en esta pantalla el layout activity_registro.xml (res/layout).
        setContentView(R.layout.activity_registro)
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
}