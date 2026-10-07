package pe.edu.cibertec.t2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.cibertec.t2.databinding.FragmentPregunta2Binding

class Pregunta2Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta2Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcularMerma.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnCalcularMerma) {
            val fallasInput = binding.etFallas.text.toString()

            if (fallasInput.isEmpty()) {
                binding.tvResultadoMerma.text = "Por favor, ingrese la cantidad de prendas defectuosas."
                return
            }

            val fallas = fallasInput.toIntOrNull() ?: 0

            if (fallas <= 10) {
                binding.tvResultadoMerma.text = "Nivel de merma dentro del margen admisible."
            } else {
                val exceso = fallas - 10
                val descuento = 100.00 + (28.00 * exceso)
                
                binding.tvResultadoMerma.text = """
                    Fallas registradas: $fallas
                    Exceso de prendas defectuosas: $exceso
                    Descuento total por reposición: S/ ${String.format("%.2f", descuento)}
                """.trimIndent()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}