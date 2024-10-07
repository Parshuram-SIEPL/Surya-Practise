package com.example.suryamodulepractise.leaveApply.Activity

import android.app.Application
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.suryamodulepractise.R
import com.example.suryamodulepractise.leaveApply.ViewModels.LeaveApplyViewModel

class LeaveApplyActivity : AppCompatActivity() {

//val leaveViewmodel by lazy { LeaveApplyViewModel(Application()) }

    lateinit var test : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leave_apply)

//        test = findViewById(R.id.userName)

//        var userDetails: HashMap<String,String> = HashMap()
//        userDetails.put("user_id", "693")
//        userDetails.put("auth", "b71a9d2ffff42ffa7f9cb2e26fe0d233")


//        leaveViewmodel.getUserLeaveApplyDetails(userDetails)
//
//        leaveViewmodel.applyRequestData.observe(this){
//
//
////            test.text = it?.get(0)?.fullname
//
//        }










    }
}