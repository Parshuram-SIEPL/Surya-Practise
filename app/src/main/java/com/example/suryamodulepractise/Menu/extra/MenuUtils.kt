package com.example.suryamodulepractise.Menu.extra

import com.example.suryamodulepractise.Menu.DataModels.Menu

object MenuUtils {

    fun segregateMenuItems(menuItems: List<Menu>): Map<String, List<Menu>> {

        val parentChildMap = mutableMapOf<String, MutableList<Menu>>()


        for (item in menuItems) {
            val parentId = item.parentId ?: "root"
            if (!parentChildMap.containsKey(parentId)) {
                parentChildMap[parentId] = mutableListOf()
            }
            parentChildMap[parentId]?.add(item)
        }

        return parentChildMap
    }
}