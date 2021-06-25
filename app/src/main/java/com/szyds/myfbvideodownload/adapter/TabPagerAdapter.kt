package com.szyds.myfbvideodownload.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.szyds.myfbvideodownload.fragment.AboutFragment
import com.szyds.myfbvideodownload.fragment.DownloadTaskFragment
import com.szyds.myfbvideodownload.fragment.FbPageFragment
import com.szyds.myfbvideodownload.fragment.LinkFragment


const val LINK_PAGE_INDEX = 0
const val FB_PAGE_INDEX = 1
const val DOWNLOAD_PAGE_INDEX = 2
const val MORE_PAGE_INDEX = 3


class TabPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentCreators: Map<Int, () -> Fragment> = mapOf(
        LINK_PAGE_INDEX to { LinkFragment() },
        FB_PAGE_INDEX to { FbPageFragment() },
        DOWNLOAD_PAGE_INDEX to { DownloadTaskFragment() },
        MORE_PAGE_INDEX to { AboutFragment() }
    )

    override fun getItemCount() = tabFragmentCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }


}