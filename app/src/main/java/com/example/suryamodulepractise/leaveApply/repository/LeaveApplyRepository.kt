package com.example.suryamodulepractise.leaveApply.repository

import com.example.suryamodulepractise.MasterClasses.RetrofitInstance
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedListModel
import retrofit2.Response

object LeaveApplyRepository {


    suspend fun callLeaveAppliedListAPI(userDetails: Map<String, String>): Response<LeaveAppliedListModel> {

        return RetrofitInstance.APiInterface.requestLeaveAppliedList(userDetails)
    }
}