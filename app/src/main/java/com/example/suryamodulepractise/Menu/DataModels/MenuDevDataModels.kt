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

data class MenuItem(
    val menu: Menu,
    var isExpanded: Boolean = false,
    var children: MutableList<MenuItem> = mutableListOf()
)