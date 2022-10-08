package com.example.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        supportActionBar!!.hide()
        val name =  SecurityPreferences(this).getString("name")
        binding.userName.text = "Olá, $name!"

        binding.buttonNewPhrase.setOnClickListener { this}


    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_new_phrase) {
            val phrase = "Estou aprendendo Kotlin"


        }

    }
}