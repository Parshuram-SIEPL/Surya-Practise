package com.example.suryamodulepractise.Menu.Repository

import com.example.suryamodulepractise.MasterClasses.RetrofitInstance
import com.example.suryamodulepractise.Menu.DataModels.MenuDevModel
import retrofit2.Response

object MenuRepository {

    suspend fun getMenuDetails(userDetails: Map<String, String>): Response<MenuDevModel> {
        return RetrofitInstance.APiInterface.getUserMenu(userDetails)
    }
}