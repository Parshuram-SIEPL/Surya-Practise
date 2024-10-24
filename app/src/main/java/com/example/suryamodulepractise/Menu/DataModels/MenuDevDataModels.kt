package com.example.suryamodulepractise.Menu.DataModels

data class MenuDevModel(
    val menu_list: List<Menu>,
    val message: String,
    val status: String
)

data class Menu(
    val menuId: String,
    val menuName: String,
    val parentId: String
)