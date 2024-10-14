package com.example.suryamodulepractise.leaveApply.repository

import com.example.suryamodulepractise.MasterClasses.RetrofitInstance
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedItemViewDetailsModel
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedListModel
import com.example.suryamodulepractise.leaveApply.DataModels.RaiseRequestDataModel
import retrofit2.Response

object LeaveApplyRepository {


    suspend fun callLeaveAppliedListAPI(userDetails: Map<String, String>): Response<LeaveAppliedListModel> {

        return RetrofitInstance.APiInterface.requestLeaveAppliedList(userDetails)
    }

    suspend fun callLeaveDetailsViewAPI(userDetails: Map<String, String>): Response<LeaveAppliedItemViewDetailsModel> {


        return RetrofitInstance.APiInterface.requestLeaveDetailsView(userDetails)
    }

    suspend fun callRaiseLeaveRequestAPI(userDetails: Map<String, String>): Response<RaiseRequestDataModel> {
        return RetrofitInstance.APiInterface.requestRaiseLeaveRequest(userDetails)

    }
}