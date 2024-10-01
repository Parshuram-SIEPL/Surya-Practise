package com.example.suryamodulepractise.NetWorkUtils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NetworkConnection {

    private var networkState: MutableLiveData<Boolean> = MutableLiveData()

    val mNetWorkState: MutableLiveData<Boolean>
        get() = networkState

    fun isNetWorkAvailable(context: Context) {


        var manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        var activeNetworkInfo: NetworkInfo? = manager.activeNetworkInfo



    }
}