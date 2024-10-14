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
import com.example.suryamodulepractise.databinding.FragmentViewDetailsBinding
import com.example.suryamodulepractise.leaveApply.ViewModels.LeaveApplyViewModel
import com.example.suryamodulepractise.leaveApply.adapters.LeaveViewDetailsAdapter


class ViewDetailsFragment : Fragment() {

    lateinit var recyclerView: RecyclerView

    val leaveApplyViewModel by lazy { LeaveApplyViewModel(Application()) }

    lateinit var binding : FragmentViewDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentViewDetailsBinding.bind(view)


        recyclerView = view.findViewById(R.id.detailsViewRecycler)



        var bundle = this.arguments
        var id = bundle?.getString("id")

        recyclerView.layoutManager = LinearLayoutManager(context)


        var userDetalsForView: HashMap<String,String> = HashMap()
        userDetalsForView.put("user_id","693")
        userDetalsForView.put("auth","b71a9d2ffff42ffa7f9cb2e26fe0d233")
        if (id != null) {
            userDetalsForView.put("id",id)
        }


        leaveApplyViewModel.getUserLeaveDetailsView(userDetalsForView)


        leaveApplyViewModel.mLeaveDetailsViewData.observe(this as LifecycleOwner){


            with(binding){
                detailUserNameHolder.text = it.all_details[0].fullname
                detailUserDeptHolder.text = it.all_details[0].dept_name
                detailRepoPersonHolder.text = it.all_details[0].reportingprsn
                detailUserFdateHolder.text = it.all_details[0].from_date
                detailUserWorkTypeHolder.text = it.all_details[0].type
                detailUserNoFDayHolder.text = it.all_details[0].fullday
                detailUserLvBalanceHolder.text = it.all_details[0].lv_balance
                dtlNoUnpaidLvHolder.text = it.all_details[0].no_of_unpaid
                detailNoPaidLvHolder.text = it.all_details[0].no_of_paid
                detailUserRsnLvHolder.text = it.all_details[0].res_of_lv
                detailUserLocationHolder.text = it.all_details[0].lname
                dtlUserLvTypeHolder.text = it.all_details[0].lv_type
                dtlUserToDateHolder.text = it.all_details[0].to_date
                detailUserLvDurationHolder.text = it.all_details[0].lv_duration
                dtlUserNoHdayHolder.text = it.all_details[0].halfday
                dtlUserTLvAplyHolder.text = it.all_details[0].t_lv_apply
            }

            recyclerView.adapter = LeaveViewDetailsAdapter(it.leave_applied)
        }




    }

}