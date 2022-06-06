package com.example.handler

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.handler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var handler:Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handler = Handler(Looper.getMainLooper())
        handler.postDelayed(runnable,1000)


    }

    private var runnable=object :Runnable{
        override fun run() {
            binding.progressBar.progress=binding.progressBar.progress+2
            Thread.sleep(1000)
            handler.postDelayed(this,1000)
            }

        }

    }

