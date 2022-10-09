package com.example.motivation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(binding.root)
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageInclusive.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        supportActionBar!!.hide()
        val name =  SecurityPreferences(this).getString("name")
        binding.userName.text = "Olá, $name!"
        val list = listOf(
            "Não sabendo que era impossível, foi lá e fez.",
            "O que você pode fazer agora para melhorar a sua situação?",
            "A persistência é o caminho do êxito.",
            "Motivação é a arte de fazer as pessoas fazerem o que você quer que elas façam porque elas o querem fazer.",
            "Se você traçar metas absurdamente altas e falhar, seu fracasso será muito melhor que o sucesso de todos.",
            "A melhor vingança é um sucesso estrondoso.",
            "O que você faz hoje pode melhorar todos os seus amanhãs.",
            "Acredite em milagres, mas não dependa deles.",
            "A maior barreira para o sucesso é o medo do fracasso."
        )
        handleFilter(R.id.image_inclusive)

    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_new_phrase) {
            Toast.makeText(this, "Ola", Toast.LENGTH_SHORT).show()
        } else if (view.id in listOf(R.id.image_inclusive, R.id.image_happy, R.id.image_sunny)){
            handleFilter(view.id)
        }
    }

    private fun handleFilter(id: Int) {
        binding.imageInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when(id) {
            R.id.image_inclusive -> {
                binding.imageInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.INCLUSIVE
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }



    }
}