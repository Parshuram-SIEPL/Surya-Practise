package com.example.suryamodulepractise.leaveApply.DataModels

data class LeaveAppliedListModel(
    val data_details: List<DataDetail>,
    val message: String,
    val status: String
)

data class DataDetail(
    val aprv_sts: String,
    val edit_sts: String,
    val from_date: String,
    val fullname: String,
    val id: String,
    val lname: String,
    val lv_duration: String,
    val req_no: String,
    val reqdate: String,
    val stat: String,
    val stg_cl: String,
    val stg_name: String,
    val t_lv_apply: String,
    val to_date: String
)