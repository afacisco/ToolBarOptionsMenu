package com.juanfra.toolbaroptionsmenu

import android.app.AlertDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Autor: Juan Francisco Sánchez González
Fecha: 03/11/2024
Clase: Actividad que contiene una Toolbar con un OptionsMenu y la opción de volver atrás.
*/

class MainActivity : AppCompatActivity() {

    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configurar Toolbar
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Mostrar el botón de retroceso, si lo necesitas
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    // Inflar el menú de opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Manejar la selección de elementos del menú
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.mnOp1 -> {
                // Acciones para "Opción 1"
                Toast.makeText(this, getString(R.string.menu_main_op1), Toast.LENGTH_SHORT).show()
                true
            }
            R.id.mnOp2 -> {
                // Acciones para "Opción 2" con la implementación de un diálogo
                val builder = AlertDialog.Builder(this)
                builder.setTitle(getString(R.string.dialogo_salir_tit))
                    .setMessage(getString(R.string.dialogo_salir_men))
                    .setIcon(android.R.drawable.ic_lock_power_off)
                    .setPositiveButton(getString(R.string.dialogo_salir_pbtn)) { dialog, _ ->
                        finish()
                    }
                    .setNegativeButton(getString(R.string.dialogo_salir_nbtn)) { dialog, _ ->
                        dialog.dismiss()
                    }
                val alertDialog = builder.create()
                alertDialog.show()
                true
            }
            R.id.mnOp3 -> {
                // Acciones para "Opción 3"
                Toast.makeText(this, getString(R.string.menu_main_op3), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}