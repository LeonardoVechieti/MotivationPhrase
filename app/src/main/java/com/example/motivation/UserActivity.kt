package com.example.motivation

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener(this)
        supportActionBar!!.hide()
        verifyUserName()
    }

    override fun onClick(view: View) {
       if (view.id == R.id.btn_start) {
           handleSave()
       }
    }
    private fun handleSave() {

        val name = binding.editName.text.toString()
        if (name != "") {
            SecurityPreferences(this).storeString("name", name)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        } else {
            Toast.makeText(this, "Informe seu nome!", Toast.LENGTH_SHORT).show()
        }
    }
    private fun verifyUserName() {
        val name = SecurityPreferences(this).getString("name")
        if (name != "") {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
    }
}