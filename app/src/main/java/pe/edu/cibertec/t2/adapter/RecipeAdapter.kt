package pe.edu.cibertec.t2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.t2.databinding.ItemRecipeBinding
import pe.edu.cibertec.t2.retrofit.response.Recipe

class RecipeAdapter(private var list: List<Recipe>) :
    RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(recipe: Recipe) {
            binding.tvId.text = "ID: ${recipe.id}"
            binding.tvName.text = recipe.name
            binding.tvPrepTime.text = "Prep Time: ${recipe.prepTimeMinutes} mins"
            binding.tvDifficulty.text = "Difficulty: ${recipe.difficulty}"
            binding.tvCuisine.text = "Cuisine: ${recipe.cuisine}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.bind(list[position])
    }
    
    fun actualizarRecetas(nuevasRecetas: List<Recipe>) {
        list = nuevasRecetas
        notifyDataSetChanged()
    }
}