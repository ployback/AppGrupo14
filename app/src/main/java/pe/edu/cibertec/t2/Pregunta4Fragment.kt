package pe.edu.cibertec.t2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import pe.edu.cibertec.t2.adapter.RecipeAdapter
import pe.edu.cibertec.t2.databinding.FragmentPregunta4Binding
import pe.edu.cibertec.t2.retrofit.ClienteRetrofit
import pe.edu.cibertec.t2.retrofit.response.RecipeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Pregunta4Fragment : Fragment() {

    private var _binding: FragmentPregunta4Binding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta4Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        adapter = RecipeAdapter(emptyList())
        binding.rvRecipes.adapter = adapter
        
        cargarRecetas()
    }

    private fun cargarRecetas() {
        val call = ClienteRetrofit.recipeService.obtenerRecetas()
        
        call.enqueue(object : Callback<RecipeResponse> {
            override fun onResponse(call: Call<RecipeResponse>, response: Response<RecipeResponse>) {
                if (response.isSuccessful) {
                    val recetas = response.body()?.recipes ?: emptyList()
                    adapter.actualizarRecetas(recetas)
                } else {
                    Toast.makeText(requireContext(), "Error en la respuesta: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<RecipeResponse>, t: Throwable) {
                Toast.makeText(requireContext(), "Fallo la conexión: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}