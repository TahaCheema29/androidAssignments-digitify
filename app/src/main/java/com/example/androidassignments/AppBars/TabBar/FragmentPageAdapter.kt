package com.example.androidassignments.AppBars.TabBar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidassignments.AppBars.BlankFragment
import com.example.androidassignments.AppBars.BlankFragment2
import com.example.androidassignments.AppBars.BlankFragment3

class FragmentPageAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
):FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount()=3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> BlankFragment()
            1 -> BlankFragment2()
            else -> BlankFragment3()
        }
    }
}