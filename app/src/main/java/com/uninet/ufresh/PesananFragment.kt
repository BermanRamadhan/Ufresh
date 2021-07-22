package com.uninet.ufresh

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.uninet.ufresh.adapter.PesananTabAdapter
import com.uninet.ufresh.pesanan.*
import com.uninet.ufresh.util.CenteringTabLayout

class PesananFragment : Fragment() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_pesanan, container, false)
        tabLayout = view.findViewById(R.id.tab__pesanan)
        viewPager = view.findViewById(R.id.vp__pesanan)
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpTab()
    }

    private fun setUpTab(){
        val adapter = PesananTabAdapter(childFragmentManager)
        adapter.addFragment(FragmentTabBelumBayar(),"BELUM BAYAR")
        adapter.addFragment(FragmentTabKemas(),"DIKEMAS")
        adapter.addFragment(FragmentTabKirim(),"DIKIRIM")
        adapter.addFragment(FragmentTabTerima(),"SELESAI")
        adapter.addFragment(FragmentTabBatal(),"DIBATALKAN")
        viewPager!!.adapter = adapter
        tabLayout!!.setupWithViewPager(viewPager)
    }

}