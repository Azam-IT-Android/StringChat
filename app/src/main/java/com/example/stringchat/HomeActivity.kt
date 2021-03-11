package com.example.stringchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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

        TabLayoutMediator(tabLayout, viewpager){
            tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }

}