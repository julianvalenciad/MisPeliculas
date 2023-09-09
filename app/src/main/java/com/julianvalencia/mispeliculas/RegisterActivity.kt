package com.julianvalencia.mispeliculas

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.julianvalencia.mispeliculas.databinding.ActivityRegisterBinding
import java.util.Calendar
import java.util.Locale


class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding: ActivityRegisterBinding
    private var cal = Calendar.getInstance()
    private var FechaNacimiento:String = ""
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
            val ciudades = registerBinding.spinnerCity.selectedItem.toString()
            var genero = "Masculino"
            if (registerBinding.femaleRadioButton.isChecked){
                genero = "Femenino"
            }

            if (email == "" || password == "" || genero == "" || ciudades == "" || FechaNacimiento == "") {
                Toast.makeText(this, "Falta ingresar algún elemento", Toast.LENGTH_LONG).show()
            }else {
                if (password == repPassword) {
                    val info = email + "\n" + password + "\n" + genero + "\n" + ciudades + "\n" + FechaNacimiento
                    registerBinding.infoTextView.text = info
                } else{
                    Toast.makeText(this,"Las contraseñas no son iguales", Toast.LENGTH_LONG).show()
                }
            }
        }

        val dateSetListener =
            DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(format, Locale.US)
                FechaNacimiento = sdf.format(cal.time).toString()
                registerBinding.datebutton.setText(FechaNacimiento)
            }

        registerBinding.datebutton.setOnClickListener {
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }






    }

}