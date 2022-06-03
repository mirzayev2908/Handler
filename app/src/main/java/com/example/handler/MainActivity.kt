package com.example.handler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.example.handler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
        private var counter=0
        private var time:Long=0
        private lateinit var handler:Handler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}