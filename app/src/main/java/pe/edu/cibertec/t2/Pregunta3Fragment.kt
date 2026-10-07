package pe.edu.cibertec.t2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.cibertec.t2.adapter.FrutaAdapter
import pe.edu.cibertec.t2.databinding.FragmentPregunta3Binding

class Pregunta3Fragment : Fragment() {

    private var _binding: FragmentPregunta3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val frutas = listOf(
            "Manzana", "Plátano", "Naranja", "Fresa", "Uva",
            "Mango", "Sandía", "Melón", "Papaya", "Pera",
            "Mandarina", "Limón", "Kiwi", "Piña", "Durazno",
            "Ciruela", "Cereza", "Frambuesa", "Arándano", "Coco"
        )
        binding.rvFrutas.adapter = FrutaAdapter(frutas)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}