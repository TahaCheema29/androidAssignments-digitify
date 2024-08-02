package com.example .androidassignments.AppBars.TabBar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.androidassignments.databinding.ActivityTabBarBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class TabBarActivity : AppCompatActivity() {

    private lateinit var binding:ActivityTabBarBinding
    private lateinit var vpAdapter: FragmentStateAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityTabBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vpAdapter=FragmentPageAdapter(supportFragmentManager,lifecycle)
        binding.viewPager.adapter=vpAdapter


        binding.tabLayout.addOnTabSelectedListener(object :OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager.currentItem=tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

        binding.viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })
    }

    override fun onBackPressed() {
        if(binding.viewPager.currentItem==0){
            super.onBackPressed()
        }else{
            binding.viewPager.currentItem=0
        }
    }
}

