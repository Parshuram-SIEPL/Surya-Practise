package com.example.suryamodulepractise.LogIn

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.suryamodulepractise.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        var handler = Handler(Looper.getMainLooper())


        handler.postDelayed({


            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 700)

    }
}