package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab?.id == R.id.tab1){
                    viewpager.currentItem = 0
                } else if(tab?.id == R.id.tab2){
                    viewpager.currentItem = 1
                } else{
                    viewpager.currentItem = 2
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}

        })
        viewpager.adapter = object :FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return 3
            }

            // 3 -> 0, 1, 2
            override fun createFragment(position: Int): Fragment {
                if(position == 0){
                    return Page1Fragment()
                } else if(position == 1){
                    return Page2Fragment()
                } else{
                    return Page3Fragment()
                }
            }
        }
    }

}