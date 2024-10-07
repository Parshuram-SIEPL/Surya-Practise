package com.example.suryamodulepractise.leaveApply.adapters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.suryamodulepractise.R
import com.example.suryamodulepractise.leaveApply.DataModels.DataDetail
import com.example.suryamodulepractise.leaveApply.fragments.LeaveAppliedListFragment
import com.example.suryamodulepractise.leaveApply.fragments.ViewDetailsFragment

class LeaveAppliedListAdapter(var datalist: List<DataDetail> , var myManager : FragmentManager) :
    RecyclerView.Adapter<LeaveAppliedListAdapter.myViewHolder>() {


    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var userName = view.findViewById<TextView>(R.id.userNameHolder)
        var requestDate = view.findViewById<TextView>(R.id.requestDateHolder)
        var requestStatus = view.findViewById<TextView>(R.id.requestStatusHolder)
        var requestStage = view.findViewById<TextView>(R.id.requestStageHolder)

        var userLocationHolder = view.findViewById<TextView>(R.id.userLocationHolder)

        var startDateHolder = view.findViewById<TextView>(R.id.startDateHolder)

        var lvDurationHolder = view.findViewById<TextView>(R.id.lvDurationHolder)

        var requestNoHolder = view.findViewById<TextView>(R.id.requestNoHolder)

        var endDateHolder = view.findViewById<TextView>(R.id.endDateHolder)

        var noLvApplyHolder = view.findViewById<TextView>(R.id.noLvApplyHolder)
        var buttonViewLeaveApplyItem = view.findViewById<TextView>(R.id.buttonViewLeaveApplyItem)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {

        var myView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leave_applied_list, parent, false)

        return myViewHolder(myView)
    }

    override fun getItemCount(): Int {


        return datalist.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {

        var myData = datalist[position]

        with(holder) {
            userName.text = myData.fullname
            requestDate.text = myData.reqdate
            requestStatus.text = myData.aprv_sts
            requestStage.text = myData.stg_name

            userLocationHolder.text = myData.lname

            startDateHolder.text = myData.from_date

            lvDurationHolder.text = myData.lv_duration

            requestNoHolder.text = myData.req_no

            endDateHolder.text = myData.to_date

            noLvApplyHolder.text = myData.t_lv_apply
        }

        holder.buttonViewLeaveApplyItem.setOnClickListener {

            var bundle = Bundle()
            bundle.putString("id",myData.id)

            var fragment = ViewDetailsFragment()
            fragment.arguments = bundle


            var manager = myManager
            var transaction = manager.beginTransaction()
            transaction.replace(R.id.leaveACFrameLayout, fragment)
            transaction.addToBackStack("fragmentLast")
            transaction.commit()

        }

    }


}
