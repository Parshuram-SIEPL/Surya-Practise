package com.example.suryamodulepractise.MasterClasses

import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedItemViewDetailsModel
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedListModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APICallsList {


    @POST(APIList.leaveAppliedList_url)
    suspend fun requestLeaveAppliedList(@Body UserDetails: Map<String, String>): Response<LeaveAppliedListModel>

    @POST(APIList.leave_apply_myrequest_list_details)
    suspend fun requestLeaveDetailsView(@Body UserDetails: Map<String, String>): Response<LeaveAppliedItemViewDetailsModel>

}