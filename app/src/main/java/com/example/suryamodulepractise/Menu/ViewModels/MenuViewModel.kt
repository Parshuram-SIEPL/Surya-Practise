package com.example.suryamodulepractise.Menu.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.suryamodulepractise.Menu.DataModels.Menu
import com.example.suryamodulepractise.Menu.Repository.MenuRepository
import kotlinx.coroutines.launch

class MenuViewModel(application: Application):AndroidViewModel(application) {

    private val menuData: MutableLiveData<List<Menu>> = MutableLiveData()

    val mMenuData: LiveData<List<Menu>> get() = menuData



    fun getMenuDetails(userDetails: Map<String, String>) {

        viewModelScope.launch {

            val response = MenuRepository.getMenuDetails(userDetails)


            if (response.isSuccessful) {

                if (response.body()?.status == "200") {

                    menuData.postValue(response.body()?.menu_list)
                }
            }

        }
    }




}