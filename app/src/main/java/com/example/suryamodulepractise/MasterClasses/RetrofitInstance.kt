package com.example.suryamodulepractise.MasterClasses

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = APIList.BASE_URL

//    companion object {
//
//        private const val BASE_URL = APIList.BASE_URL
//        private var APiInterface:APICallsList
//
//        init {
//            APiInterface = getInstance().create(APICallsList::class.java)
//
//        }
//
//        fun getInstance(): Retrofit {
//
//            var retrofit = Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create()).build()
//            return retrofit as Retrofit
//        }
//
//
//    }

    val APiInterface: APICallsList by lazy {

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APICallsList::class.java)

    }

}