package com.example.myapps.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapps.ui.fragment.WalkthroughPageFragment

data class WalkthroughPage(
    val imageResId: Int,
    val title: String,
    val description: String
)

class WalkthroughPagerAdapter(
    fragment: Fragment,
    private val pages: List<WalkthroughPage>
) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int = pages.size


    override fun createFragment(position: Int): Fragment {
        val page = pages[position]
        return WalkthroughPageFragment.newInstance(page.imageResId, page.title, page.description)
    }
}