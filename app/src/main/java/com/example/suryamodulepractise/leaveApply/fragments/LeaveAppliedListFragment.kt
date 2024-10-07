package com.example.suryamodulepractise.leaveApply.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.suryamodulepractise.R
import com.example.suryamodulepractise.leaveApply.DataModels.DataDetail
import com.example.suryamodulepractise.leaveApply.ViewModels.LeaveApplyViewModel
import com.example.suryamodulepractise.leaveApply.adapters.LeaveAppliedListAdapter


class LeaveAppliedListFragment : Fragment() {

    val leaveApplyViewModel by lazy { LeaveApplyViewModel(Application()) }
//    lateinit var datalist : List<DataDetail>

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_leave_applied_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.leaveAppliedListRecyclerView)

//        datalist = emptyList()

        var userDetails: HashMap<String,String> = HashMap()
        userDetails.put("user_id", "693")
        userDetails.put("auth", "b71a9d2ffff42ffa7f9cb2e26fe0d233")






        leaveApplyViewModel.getUserLeaveApplyDetails(userDetails)
        recyclerView.layoutManager = LinearLayoutManager(context)


        leaveApplyViewModel.applyRequestData.observe(this as LifecycleOwner){

            recyclerView.adapter = LeaveAppliedListAdapter(it,parentFragmentManager)
        }











    }




}