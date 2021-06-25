package com.szyds.myfbvideodownload.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.szyds.myfbvideodownload.R
import com.szyds.myfbvideodownload.adapter.*
import com.szyds.myfbvideodownload.databinding.FragmentHomeBinding
import java.lang.IndexOutOfBoundsException

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = TabPagerAdapter(this)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setIcon(getTabIcon(position))
        }.attach()

        return binding.root
    }

    private fun getTabIcon(position: Int): Int {
        return when (position) {
            LINK_PAGE_INDEX -> R.drawable.u1
            FB_PAGE_INDEX -> R.drawable.u0
            DOWNLOAD_PAGE_INDEX -> R.drawable.u2
            MORE_PAGE_INDEX -> R.drawable.u3
            else -> throw IndexOutOfBoundsException()
        }
    }


}