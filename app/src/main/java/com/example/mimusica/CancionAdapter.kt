package com.example.mimusica
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CancionAdapter(private val canciones: List<Cancion>):
RecyclerView.Adapter<CancionAdapter.FilaViewHolder>()
{
    class FilaViewHolder(view: View): RecyclerView.ViewHolder(view)
    {
        val txtTitulo: TextView = view.findViewById(R.id.txtTituloFilaItem)
        val txtArtista: TextView = view.findViewById(R.id.txtArtistaFilaItem)
        val txtVeces: TextView = view.findViewById(R.id.txtVecesFilaItem)
        val btnMasUno: Button = view.findViewById(R.id.btnMasUnoFilaItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cancion, parent, false)
        return FilaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return canciones.size
    }

    override fun onBindViewHolder(holder: FilaViewHolder, position: Int) {
       val cancion = canciones[position]
        holder.txtTitulo.text =cancion.titulo
        holder.txtArtista.text= cancion.artista
        holder.txtVeces.text = "Escuchada ${cancion.veces} veces"

        holder.btnMasUno.setOnClickListener{
            cancion.veces = cancion.veces+1
            holder.txtVeces.text = "Escuchada ${cancion.veces} veces"
        }

        holder.itemView.setOnClickListener{
            val contexto = holder.itemView.context
            val intent = Intent(contexto, DetalleActivity::class.java)
            intent.putExtra("cancion", cancion.titulo)
            intent.putExtra("artista", cancion.artista)
            intent.putExtra("genero", cancion.genero)
            intent.putExtra("veces", cancion.veces)
            contexto.startActivity(intent)
        }
    }
}