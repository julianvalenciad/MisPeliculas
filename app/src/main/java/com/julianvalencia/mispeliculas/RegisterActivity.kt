package com.julianvalencia.mispeliculas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.julianvalencia.mispeliculas.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = registerBinding.root
        setContentView(view)

        registerBinding.registerButton.setOnClickListener {
            Log.d("button","clicked")
            val email = registerBinding.emailEditText.text.toString()
            val password = registerBinding.passwordEditText.text.toString()
            val repPassword = registerBinding.repPasswordEditText.text.toString()
            var genero = "Masculino"
            if (registerBinding.femaleRadioButton.isChecked){
                genero = "Femenino"
            }

            if (password == repPassword){
                val info = email + "\n" +password + "\n" + genero
                registerBinding.infoTextView.text = info
            } else{
                Toast.makeText(this,"Las contraseñas no son iguales", Toast.LENGTH_LONG).show()
            }



        }
    }
}