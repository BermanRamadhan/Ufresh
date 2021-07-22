package com.uninet.ufresh.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PesananTabAdapter(fragmentManager:FragmentManager) : FragmentPagerAdapter(fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mFragmentPesananTab = ArrayList<Fragment>()
    private val mFragmentListTitle = ArrayList<String>()

    override fun getCount(): Int {
        return mFragmentPesananTab.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentPesananTab.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentListTitle.get(position)
    }

    fun addFragment(fragment: Fragment,title:String){
        mFragmentPesananTab.add(fragment)
        mFragmentListTitle.add(title)
    }
}