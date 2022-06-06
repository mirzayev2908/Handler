package com.example.handler

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.example.handler.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    private var counter = 0
    private var time: Long = 0L
    private lateinit var handler: Handler
    private  var closeTime:Long=0L


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())
        if (time == 0L) {
            time = SystemClock.uptimeMillis()
            handler.removeCallbacks(runnable)
            handler.postDelayed(runnable,100)
        }
        binding.button.setOnClickListener(this)


    }

    private var runnable = object : Runnable {
        override fun run() {
            val start=time
            val millis=SystemClock.uptimeMillis()-start
            var second=millis/1000
            val minute=second/60
            second %=60
            binding.timeTv.text="$minute:${String.format("%02d",second)}"
            handler.postDelayed(this,200)

        }

    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
        closeTime=SystemClock.uptimeMillis()-time

    }

    override fun onResume() {
        super.onResume()
        time=SystemClock.uptimeMillis()-closeTime
        handler.postDelayed(runnable,100)

    }

    override fun onClick(p0: View?) {
            binding.counterTv.text=(++counter).toString()
    }
}