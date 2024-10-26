package com.example.suryamodulepractise.Menu.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.suryamodulepractise.Menu.DataModels.Menu
import com.example.suryamodulepractise.Menu.DataModels.MenuDevModel
import com.example.suryamodulepractise.Menu.DataModels.MenuItem
import com.example.suryamodulepractise.Menu.Repository.MenuRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class ItemViewModel : ViewModel() {

    private val _menuItems = MutableLiveData<List<MenuItem>>()
    val menuItems: LiveData<List<MenuItem>> get() = _menuItems

    // List of IDs of MenuItems Allowed In Android Live
    var liveMenuListForAndroid = listOf(

        "522",

        "578",

        "579",

        "581",

        "587",

        "593",

        "896",

        "897",

        //"584",
        //"898",

        //   "1",
        // "19",

        "311",

        //         "34",

        //  "344",
        // "345",
        // "342",
        //  "343",

        //  "340",
        // "341",
        // "350",

        // "348",
        //"713",


        "506",

        // "512",

        "537",

        //  "583",
        //   "591",


        "451",

        //"924",

        //  "844",

        "456",


        //   "453",


        //  "452",

        "686",

        "718",

        "931",

        "932",

        // "1005",
        // "1006",
        //"792",
        //  "803",
        // "798",

        "732",
        "743",
        "738"
    )

    fun fetchMenuItems(userDetails: Map<String, String>) {
        viewModelScope.launch {
            try {
                val response: Response<MenuDevModel> = MenuRepository.getMenuDetails(userDetails)
                if (response.isSuccessful) {
                    response.body()?.let { body ->
                        if (body.status == "200") {

                            val menuItemMap = mutableMapOf<String, MenuItem>()
                            for (menu in body.menu_list) {
                                menuItemMap[menu.menuId] = MenuItem(menu)
                            }
                            for (menu in body.menu_list) {
                                if (menu.parentId != "0") {
                                    menuItemMap[menu.parentId]?.children?.add(menuItemMap[menu.menuId]!!)
                                }
                            }
                            val filteredMenuItems = filterMenuItems(menuItemMap)
                            _menuItems.value = filteredMenuItems
                        }
                    }
                } else {
                    Log.e("API Error", "Error Code: ${response.code()} - ${response.message()}")
                    _menuItems.value = emptyList() // Handle error state
                }
            } catch (e: Exception) {
                Log.e("Network Error", "Exception: ${e.message}")
                _menuItems.value = emptyList() // Handle network error state
            }
        }
    }

    // Function to filter menu items based on allowed IDs and avoid duplicates
    private fun filterMenuItems(menuItemMap: Map<String, MenuItem>): List<MenuItem> {
        val result = mutableListOf<MenuItem>()
        val addedIds = mutableSetOf<String>() // Set to keep track of added item IDs

        for ((_, item) in menuItemMap) {
            // If item is allowed and not already added, add it
            if (item.menu.menuId in liveMenuListForAndroid && item.menu.menuId !in addedIds) {
                result.add(item.copy(children = filterChildren(item.children, addedIds))) // Recursively filter children
                addedIds.add(item.menu.menuId)
            }
        }
        return result
    }

    // Function to filter children and grandchildren while avoiding duplicates
    private fun filterChildren(children: MutableList<MenuItem>, addedIds: MutableSet<String>): MutableList<MenuItem> {
        val filteredChildren = mutableListOf<MenuItem>()
        for (child in children) {
            // Check if the child is allowed and not already added
            if (child.menu.menuId in liveMenuListForAndroid && child.menu.menuId !in addedIds) {
                filteredChildren.add(child.copy(children = filterChildren(child.children, addedIds)))
                addedIds.add(child.menu.menuId)
            }
        }
        return filteredChildren
    }
}
