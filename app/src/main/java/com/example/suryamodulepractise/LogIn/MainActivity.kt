package com.example.suryamodulepractise.LogIn

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suryamodulepractise.databinding.ActivityMainBinding
import com.example.suryamodulepractise.leaveApply.Activity.LeaveApplyActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.button.setOnClickListener {

            val intent = Intent(this, LeaveApplyActivity::class.java)
            startActivity(intent)


        }

    }
}
