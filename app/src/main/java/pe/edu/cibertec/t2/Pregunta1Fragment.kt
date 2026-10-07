package pe.edu.cibertec.t2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.cibertec.t2.databinding.FragmentPregunta1Binding

class Pregunta1Fragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPregunta1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalcular.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnCalcular) {
            val diasInput = binding.etDias.text.toString()

            if (diasInput.isEmpty()) {
                binding.tvResultado.text = "Por favor, ingrese los días de retraso."
                return
            }

            val dias = diasInput.toIntOrNull() ?: 0

            if (dias <= 5) {
                binding.tvResultado.text = "Entrega dentro de la tolerancia contractual."
            } else {
                val diasComputables = dias - 5
                val descuento = 500.00 + (150.00 * diasComputables)
                
                binding.tvResultado.text = """
                    Días de retraso: $dias
                    Días computables para penalidad: $diasComputables
                    Descuento resultante: S/ ${String.format("%.2f", descuento)}
                """.trimIndent()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}