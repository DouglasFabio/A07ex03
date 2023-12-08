package com.example.a07ex03

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fabChamadas = findViewById<ExtendedFloatingActionButton>(R.id.fabChamadas)
        val fabNavegador = findViewById<ExtendedFloatingActionButton>(R.id.fabNavegador)
        val fabSMS = findViewById<ExtendedFloatingActionButton>(R.id.fabSMS)
        val fabEmail = findViewById<ExtendedFloatingActionButton>(R.id.fabEmail)

        fabChamadas.setOnClickListener {
            val intentChamadas = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:" + "1234567890") // Substitua pelo número desejado
            }
            startActivity(intentChamadas)
        }

        fabNavegador.setOnClickListener {
            val intentNavegador = Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"))
            startActivity(intentNavegador)
        }

        fabSMS.setOnClickListener {
            val intentSMS = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("sms:" + "1234567890") // Substitua pelo número desejado
                putExtra("sms_body", "Olá!") // Substitua por sua mensagem
            }
            startActivity(intentSMS)
        }

        fabEmail.setOnClickListener {
            val intentEmail = Intent(Intent.ACTION_SEND)
            intentEmail.data = Uri.parse("mailto:")
            intentEmail.type = "message/rfc822"
            intentEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("email1@teste.com", "email2@teste.com"));
            intentEmail.putExtra(Intent.EXTRA_SUBJECT, "Assunto");
            intentEmail.putExtra(Intent.EXTRA_TEXT, "Corpo");
            startActivity(intentEmail)
        }
    }
}