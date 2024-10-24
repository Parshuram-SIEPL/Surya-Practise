package com.example.suryamodulepractise.Menu

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ExpandableListView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import com.example.suryamodulepractise.Menu.ViewModels.MenuViewModel
import com.example.suryamodulepractise.R

class MenuActivity : AppCompatActivity() {

    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mDrawerToggle: ActionBarDrawerToggle
    lateinit var mToolbar: Toolbar

    lateinit var testView: TextView
    lateinit var expandableMenuListView: ExpandableListView

    val menuViewModel: MenuViewModel by lazy {
        ViewModelProvider(this).get(MenuViewModel::class.java)
    }

    lateinit var menuListAdapter: ExpandableMenuListAdapter

    lateinit var expandableListParent: List<String>
    lateinit var expandableListChild: HashMap<String, List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        mDrawerLayout = findViewById(R.id.drawer_main)
        mToolbar = findViewById(R.id.toolbar_test)
        testView = findViewById(R.id.viewTest)
        expandableMenuListView = findViewById(R.id.expandable_list_view)


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

//        var liveMenuChildListForAndroid = listOf(
//            "522",
//
//            "578",
//
//            "579",
//
//            "581",
//
//            "587",
//
//            "593",
//
//            "896",
//
//            "897",
//
//         //"584",
//         //"898",
//
//  //   "1",
//  // "19",
//
//            "311",
//
//   //         "34",
//
//          //  "344",
//           // "345",
//           // "342",
//          //  "343",
//
//          //  "340",
//           // "341",
//           // "350",
//
//           // "348",
//            //"713",
//
//
//            "506",
//
//           // "512",
//
//            "537",
//
//          //  "583",
//         //   "591",
//
//
//            "451",
//
//         //"924",
//
//          //  "844",
//
//            "456",
//
//
//          //   "453",
//
//
//          //  "452",
//
//            "686",
//
//            "718",
//
//            "931",
//
//            "932",
//
//           // "1005",
//           // "1006",
//            //"792",
//          //  "803",
//           // "798",
//
//            "732",
//            "743",
//            "738"
//        )







/*
        var devMenuListForAndroid = listOf(
            "522",
            "578",
            "579",
            "581",
            "587",
            "593",
            "994",
            "996",
            "1",
            "19",
            "311",
            "34",
            "344",
            "345",
            "342",
            "343",
            "340",
            "341",
            "350",
            "348",
            "713",
            "506",
            "512",
            "537",
            "583",
            "591",
            "451",
            "844",
            "456",
            "453",
            "452",
            "686",
            "718",
            "1005",
            "1006",
            "792",
            "803",
            "798"
        )
*/


        val userDetails: HashMap<String, String> = HashMap()
        userDetails["user_id"] = "693"
        userDetails["auth"] = "b71a9d2ffff42ffa7f9cb2e26fe0d233"

//        userDetails["user_id"] = "74"
//        userDetails["auth"] = "ebb54bef1130bb5f9776711a2316601b"
//        userDetails["auth"] = "179e69fbdace6c0632bf49876d8a8a19"


        menuViewModel.getMenuDetails(userDetails)

        // Observe the menu data from the ViewModel
//        menuViewModel.mMenuData.observe(this) { menuList ->


//            // Segregate parent and child menus
//            val parentMenus = menuList.filter { it.parentId == "0" }.map { it.menuName }
//            val childMenus = HashMap<String, List<String>>()
//
//            // Group child menus by parentId
//            parentMenus.forEach { parentMenu ->
//                val children = menuList.filter { it.parentId == menuList.first { it.menuName == parentMenu }.menuId }
//                    .map { it.menuName }
//                childMenus[parentMenu] = children
//            }
//
//
//            expandableListParent = parentMenus
//            expandableListChild = childMenus
//
//
//            menuListAdapter = ExpandableMenuListAdapter(this, expandableListParent, expandableListChild)
//            expandableMenuListView.setAdapter(menuListAdapter)
//    }


        menuViewModel.mMenuData.observe(this) { menuList ->

            // Step 1: Filter and map to unique parent items (parentId and menuName)
            val specificParentMenus = menuList
                .filter { it.parentId == "0" && it.menuId in liveMenuListForAndroid }
                .map { it.menuId to it.menuName }
                .distinctBy { it.first } // Ensure unique parents by menuId

            // Step 2: Create expandableListParent with unique parent names
            expandableListParent = specificParentMenus.map { it.second }.distinct() // Ensure unique parent names (menuName)

            // Step 3: Group child items by parentId
            expandableListChild = HashMap()
            for ((parentId, parentName) in specificParentMenus) {
                val childItems = menuList
                    .filter { it.parentId == parentId } // Correct filtering by parentId
                    .map { it.menuName }
                    .distinct() // Ensure unique child names under each parent

                expandableListChild[parentName] = if (childItems.isNotEmpty()) {
                    childItems
                } else {
                    listOf() // Empty list for parents with no children
                }
            }

            // Debug logs to verify parent and child lists
            Log.d("DEBUG", "Parent List: $expandableListParent")
            Log.d("DEBUG", "Child List: $expandableListChild")

            // Step 4: Set up the adapter
            menuListAdapter = ExpandableMenuListAdapter(this, expandableListParent, expandableListChild)
            expandableMenuListView.setAdapter(menuListAdapter)

            // Notify adapter of changes
            menuListAdapter.notifyDataSetChanged()
        }




        mDrawerToggle = ActionBarDrawerToggle(
            this, mDrawerLayout, R.string.open_drawer, R.string.close_drawer
        )
        mDrawerLayout.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()


        setUpToolBar()
    }


    private fun setUpToolBar() {
        setSupportActionBar(mToolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
}
