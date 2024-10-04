package com.example.suryamodulepractise.leaveApply.ViewModels

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.suryamodulepractise.leaveApply.DataModels.DataDetail
import com.example.suryamodulepractise.leaveApply.repository.LeaveApplyRepository
import kotlinx.coroutines.launch

class LeaveApplyViewModel(application: Application) :AndroidViewModel(application) {



    private val leaveApplyData : MutableLiveData<List<DataDetail>> = MutableLiveData()


    val applyRequestData : LiveData<List<DataDetail>> get() = leaveApplyData


    fun getUserLeaveApplyDetails(userDetails : Map<String , String>){

        viewModelScope.launch {

            val response = LeaveApplyRepository.callLeaveAppliedListAPI(userDetails)

            if (response.isSuccessful){

                if (response.body()?.status == "200"){

                    leaveApplyData.postValue(response.body()?.data_details)



//                    leaveApplyData.postValue()
                }


            }else{


            }

        }
    }





}