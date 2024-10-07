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


        leaveApplyViewModel.mleaveDetailsViewData.observe(this as LifecycleOwner){


            binding.detailUserNameHolder.text = it.all_details[0].fullname
            binding.detailUserDeptHolder.text = it.all_details[0].dept_name
            binding.detailRepoPersonHolder.text = it.all_details[0].reportingprsn
            binding.detailUserFdateHolder.text = it.all_details[0].from_date
            binding.detailUserWorkTypeHolder.text = it.all_details[0].type
            binding.detailUserNoFDayHolder.text = it.all_details[0].fullday
            binding.detailUserLvBalanceHolder.text = it.all_details[0].lv_balance
            binding.dtlNoUnpaidLvHolder.text = it.all_details[0].no_of_unpaid
            binding.detailNoPaidLvHolder.text = it.all_details[0].no_of_paid
            binding.detailUserRsnLvHolder.text = it.all_details[0].res_of_lv
            binding.detailUserLocationHolder.text = it.all_details[0].lname
            binding.dtlUserLvTypeHolder.text = it.all_details[0].lv_type
            binding.dtlUserToDateHolder.text = it.all_details[0].to_date
            binding.detailUserLvDurationHolder.text = it.all_details[0].lv_duration
            binding.dtlUserNoHdayHolder.text = it.all_details[0].halfday
            binding.dtlUserTLvAplyHolder.text = it.all_details[0].t_lv_apply


            recyclerView.adapter = LeaveViewDetailsAdapter(it.leave_applied)


        }




    }

}