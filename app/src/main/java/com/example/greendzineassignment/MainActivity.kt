package com.example.greendzineassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import com.example.greendzineassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Find the login button using View Binding
        val loginButton: Button = binding.loginBtn
        //val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener{
            val Intent = Intent(this, MainActivity2::class.java)
            startActivity(Intent)

        }


    }





}