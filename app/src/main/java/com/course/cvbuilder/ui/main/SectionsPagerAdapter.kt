package com.course.cvbuilder.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.course.cvbuilder.R
import com.course.cvbuilder.ui.main.work.WorkFragment

private val TAB_TITLES = arrayOf(
    R.string.tab_home,
    R.string.tab_work,
    R.string.tab_about_me,
    R.string.tab_contact
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0-> HomeFragment()
            1->WorkFragment()
            2-> AboutmeFragment()
            3-> ContactFragment()
            else -> {
                HomeFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
         return 4
    }
}