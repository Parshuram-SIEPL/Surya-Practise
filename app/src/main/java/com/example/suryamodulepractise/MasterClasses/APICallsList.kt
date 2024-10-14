package com.example.suryamodulepractise.MasterClasses

import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedItemViewDetailsModel
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveAppliedListModel
import com.example.suryamodulepractise.leaveApply.DataModels.RaiseRequestDataModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APICallsList {


    @POST(APIList.leaveAppliedList_url)
    suspend fun requestLeaveAppliedList(@Body userDetails: Map<String, String>): Response<LeaveAppliedListModel>

    @POST(APIList.leave_apply_myrequest_list_details)
    suspend fun requestLeaveDetailsView(@Body userDetails: Map<String, String>): Response<LeaveAppliedItemViewDetailsModel>

    @POST(APIList.raise_leave_request)
    suspend fun requestRaiseLeaveRequest(@Body userDetails: Map<String, String>): Response<RaiseRequestDataModel>

}