package com.example.suryamodulepractise.LogIn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.suryamodulepractise.R
import com.example.suryamodulepractise.databinding.ActivityMainBinding
import com.example.suryamodulepractise.leaveApply.fragments.LeaveAppliedListFragment
import com.example.suryamodulepractise.leaveApply.fragments.RaiseLeaveRequestFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)




        binding.button.setOnClickListener {


            var transition = supportFragmentManager.beginTransaction()
            transition.replace(R.id.leaveACFrameLayout, LeaveAppliedListFragment())
            transition.addToBackStack("fragmentFirst")
            transition.commit()

        }
        binding.raiseLeaveRequestButton.setOnClickListener {
            var transition = supportFragmentManager.beginTransaction()
            transition.replace(R.id.leaveACFrameLayout, RaiseLeaveRequestFragment())
            transition.addToBackStack("fragmentApply")
            transition.commit()
        }


    }
}
