package com.example.suryamodulepractise.leaveApply.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveListItemDataModel
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedItemViewDetailsModel
import com.example.suryamodulepractise.leaveApply.DataModels.RaiseRequestDataModel
import com.example.suryamodulepractise.leaveApply.repository.LeaveApplyRepository
import kotlinx.coroutines.launch

class LeaveApplyViewModel(application: Application) : AndroidViewModel(application) {


    private val leaveApplyData: MutableLiveData<List<LeaveListItemDataModel>> = MutableLiveData()

    val applyRequestData: LiveData<List<LeaveListItemDataModel>> get() = leaveApplyData


    private val leaveDetailsViewData: MutableLiveData<LeaveAppliedItemViewDetailsModel> = MutableLiveData()

    val mLeaveDetailsViewData: LiveData<LeaveAppliedItemViewDetailsModel> get() = leaveDetailsViewData

    private val raiseLeaveRequestData: MutableLiveData<RaiseRequestDataModel> = MutableLiveData()

    val mRaiseLeaveRequestData: LiveData<RaiseRequestDataModel> get() = raiseLeaveRequestData


    fun getUserLeaveApplyDetails(userDetails: Map<String, String>) {

        viewModelScope.launch {

            val response = LeaveApplyRepository.callLeaveAppliedListAPI(userDetails)

            if (response.isSuccessful) {

                if (response.body()?.status == "200") {

                    leaveApplyData.postValue(response.body()?.data_details)

                }


            } else {


            }

        }
    }

    fun getUserLeaveDetailsView(userDetails: Map<String, String>) {

        viewModelScope.launch {

            val response = LeaveApplyRepository.callLeaveDetailsViewAPI(userDetails)

            if (response.isSuccessful) {

                if (response.body()?.status == "200") {

                    leaveDetailsViewData.postValue(response.body())

                }
            }

        }
    }
    fun getUserRaiseLeaveRequest(userDetails: Map<String, String>) {
        viewModelScope.launch {
            val response = LeaveApplyRepository.callRaiseLeaveRequestAPI(userDetails)

            if (response.isSuccessful) {
                if (response.body()?.status == "200") {
                    raiseLeaveRequestData.postValue(response.body())
                }
            }
        }
    }


}