package pe.edu.cibertec.t2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.t2.databinding.ItemFrutaBinding

class FrutaAdapter(private val listaFrutas: List<String>) :
    RecyclerView.Adapter<FrutaAdapter.FrutaViewHolder>() {

    inner class FrutaViewHolder(private val binding: ItemFrutaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(fruta: String) {
            binding.tvNombreFruta.text = fruta
            Glide.with(binding.root.context)
                .load("https://picsum.photos/150/150?random=${adapterPosition}")
                .into(binding.ivFruta)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FrutaViewHolder {
        val binding = ItemFrutaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FrutaViewHolder(binding)
    }

    override fun getItemCount(): Int = listaFrutas.size

    override fun onBindViewHolder(holder: FrutaViewHolder, position: Int) {
        holder.bind(listaFrutas[position])
    }
}