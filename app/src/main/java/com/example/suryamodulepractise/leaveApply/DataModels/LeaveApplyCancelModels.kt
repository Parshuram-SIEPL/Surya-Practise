package com.example.suryamodulepractise.leaveApply.DataModels

data class LeaveAppliedListModel(
    val data_details: List<LeaveListItemDataModel>, val message: String, val status: String
)

data class LeaveListItemDataModel(
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

data class LeaveAppliedItemViewDetailsModel(
    val all_details: List<AllDetail>,
    val apprvTrail: List<ApprvTrail>,
    val leave_applied: List<LeaveApplied>,
    val message: String,
    val reject_msg: Any,
    val status: String
)

data class AllDetail(
    val dept_name: String,
    val from_date: String,
    val fullday: String,
    val fullname: String,
    val halfday: String,
    val lname: String,
    val lv_balance: String,
    val lv_duration: String,
    val lv_type: String,
    val no_of_paid: String,
    val no_of_unpaid: String,
    val reportingprsn: String,
    val res_of_lv: String,
    val t_lv_apply: String,
    val to_date: String,
    val type: String
)

data class ApprvTrail(
    val action_by: String,
    val app_status: String,
    val created_on: String,
    val fullname: String,
    val id: String,
    val ip_add: String,
    val lv_id: String,
    val msg: Any,
    val stage_no: Any,
    val stage_remark: Any,
    val status: String
)

data class LeaveApplied(
    val dated: String, val frststhlf: String, val full_day: String, val second_half: String
)

data class RaiseRequestDataModel(
    val data_details: List<RaiseRequestDetails>,
    val disable_dates: List<DisableDate>,
    val holiday_dates: List<HolidayDate>,
    val message: String,
    val status: String
)

data class RaiseRequestDetails(
    val department_id: String,
    val dept_head: String,
    val dept_name: String,
    val leave_balance: Int,
    val loc_type: String,
    val location_id: String,
    val location_name: String,
    val mstrid: String,
    val name: String,
    val reporting_prsn: String,
    val srvc_id: String
)

data class DisableDate(
    val disabledate: List<String>, val ldt: String
)

data class HolidayDate(
    val holiday_date: String, val holiday_desc: String, val holiday_val: String
)