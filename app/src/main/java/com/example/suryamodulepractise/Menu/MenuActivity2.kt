package com.example.suryamodulepractise.Menu

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.suryamodulepractise.Menu.ViewModels.ItemViewModel
import com.example.suryamodulepractise.R

class MenuActivity2 : AppCompatActivity() {

    lateinit var mDrawerLayout: DrawerLayout
    lateinit var mDrawerToggle: ActionBarDrawerToggle
    lateinit var mToolbar: Toolbar

    private lateinit var viewModel: ItemViewModel
    private lateinit var adapter: ExpandableAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        mDrawerLayout = findViewById(R.id.drawer_main)
        mToolbar = findViewById(R.id.toolbar_test)

        mDrawerToggle = ActionBarDrawerToggle(
            this, mDrawerLayout, R.string.open_drawer, R.string.close_drawer
        )
        mDrawerLayout.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()


        setUpToolBar()


//
        val userDetails: HashMap<String, String> = HashMap()
        userDetails["user_id"] = "693"
        userDetails["auth"] = "b71a9d2ffff42ffa7f9cb2e26fe0d233"

//        val userDetails: HashMap<String, String> = HashMap()
//        userDetails["user_id"] = "74"
//        userDetails["auth"] = "179e69fbdace6c0632bf49876d8a8a19"

//        val userDetails: HashMap<String, String> = HashMap()
//        userDetails["user_id"] = "605"
//        userDetails["auth"] = "5f979c5909cdfd93a25603fca0f60753"

        viewModel = ViewModelProvider(this).get(ItemViewModel::class.java)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.menuItems.observe(this) { items ->

            adapter = ExpandableAdapter(items) { item ->
                // Handle item click
                Toast.makeText(this, "${item.menu.menuName} clicked", Toast.LENGTH_SHORT).show()
            }
            recyclerView.adapter = adapter
        }

        // Fetch the items from API
        viewModel.fetchMenuItems(userDetails)

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