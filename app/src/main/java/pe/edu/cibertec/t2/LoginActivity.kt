package pe.edu.cibertec.t2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.t2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private val listaUsuarios = mutableListOf<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inicializarUsuarios()
        binding.btnLogin.setOnClickListener(this)
    }

    private fun inicializarUsuarios() {
        listaUsuarios.add(Usuario("i202412359", "74839201", "Carlos", "Perez"))
        listaUsuarios.add(Usuario("i202212351", "48392017", "Ana", "Gomez"))
        listaUsuarios.add(Usuario("i201990351", "83920174", "Luis", "Ramirez"))
        listaUsuarios.add(Usuario("i202180352", "39201748", "Maria", "Torres"))
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btnLogin) {
            val usuarioInput = binding.etUser.text.toString().trim()
            val passwordInput = binding.etPassword.text.toString().trim()

            if (usuarioInput.isEmpty() || passwordInput.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
                return
            }

            val usuarioEncontrado = listaUsuarios.find { it.id == usuarioInput && it.clave == passwordInput }

            if (usuarioEncontrado != null) {
                Toast.makeText(this, "Bienvenido ${usuarioEncontrado.nombre}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}