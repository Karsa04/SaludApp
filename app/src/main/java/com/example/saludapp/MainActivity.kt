package com.example.saludapp

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnHello:androidx.appcompat.widget.AppCompatButton= findViewById(R.id.btnHello)
        val etName:EditText =findViewById(R.id.etName)


           btnHello.setOnClickListener {
               //Log.i("test", "Botón pulsado ")
               val name =etName.text.toString()
              // Toast.makeText(this,"Hola $name!", Toast.LENGTH_LONG).show()
               if (name.isNotEmpty()){
                   Snackbar.make(btnHello, "Hola $name!", Snackbar.LENGTH_SHORT)
                       .setAnchorView(btnHello)
                       .setAction("Reset") {etName.setText(null) }
                       .show()
               }

           }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
}