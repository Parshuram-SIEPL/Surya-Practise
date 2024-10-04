package com.example.suryamodulepractise.NetWorkUtils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class NetworkConnection {

    private var networkState: MutableLiveData<NetworkInfo> = MutableLiveData()

    val mNetWorkState: MutableLiveData<NetworkInfo>
        get() = networkState

    fun isNetWorkAvailable(context: Context) {


        var manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        var activeNetworkInfo: NetworkInfo? = manager.activeNetworkInfo


        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isAvailable){
                networkState.postValue(activeNetworkInfo)
            }
            else{
                networkState.postValue(null)
            }
        }
        else{
            networkState.postValue(null)
        }
    }


}