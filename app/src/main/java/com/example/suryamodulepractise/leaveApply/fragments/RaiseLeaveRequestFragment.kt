package com.example.suryamodulepractise.leaveApply.fragments

import android.app.Application
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.autofill.AutofillValue
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.example.suryamodulepractise.R
import com.example.suryamodulepractise.databinding.FragmentRaiseLeaveRequestBinding
import com.example.suryamodulepractise.leaveApply.ViewModels.LeaveApplyViewModel


class RaiseLeaveRequestFragment : Fragment() {

    val leaveApplyViewModel by lazy { LeaveApplyViewModel(Application()) }

    lateinit var binding : FragmentRaiseLeaveRequestBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_raise_leave_request, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRaiseLeaveRequestBinding.bind(view)

        val userDetails : HashMap<String,String> = HashMap()
        userDetails.put("user_id","693")
        userDetails.put("auth","b71a9d2ffff42ffa7f9cb2e26fe0d233")
        userDetails.put("frmdate","")
        userDetails.put("todate","")


        leaveApplyViewModel.getUserRaiseLeaveRequest(userDetails)

        leaveApplyViewModel.mRaiseLeaveRequestData.observe(this as LifecycleOwner){

            binding.userNameLvApply.setText(it.data_details[0].name)


        }
    }



}