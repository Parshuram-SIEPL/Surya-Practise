package com.example.suryamodulepractise.leaveApply.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.suryamodulepractise.R
import com.example.suryamodulepractise.leaveApply.DataModels.LeaveApplied

class LeaveViewDetailsAdapter(var datalist: List<LeaveApplied>) :
    RecyclerView.Adapter<LeaveViewDetailsAdapter.myViewHolder>() {


    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var userLeaveDate = view.findViewById<TextView>(R.id.dateHolderRecycler)
        var userLeaveType = view.findViewById<TextView>(R.id.leaveTypeHolderRecycler)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {


        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_details_view, parent, false)

        return myViewHolder(view)
    }

    override fun getItemCount(): Int {

        return datalist.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var data = datalist[position]

        with(holder) {

            if (!data.full_day.isNullOrEmpty()) {
                userLeaveDate.text = data.dated
                userLeaveType.text = data.full_day

            } else if (!data.frststhlf.isNullOrEmpty()) {
                userLeaveDate.text = data.dated
                userLeaveType.text = data.frststhlf

            } else if (!data.second_half.isNullOrEmpty()) {
                userLeaveDate.text = data.dated
                userLeaveType.text = data.second_half
            }

        }
    }
}