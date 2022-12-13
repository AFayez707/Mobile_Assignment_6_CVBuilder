package com.course.cvbuilder.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.course.cvbuilder.R
import com.course.cvbuilder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val  toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mnu_linkedin -> {
                viewWebiste("https://www.linkedin.com/in/ahmed-m-fayez/")
            }
            R.id.mnu_twitter -> {
                viewWebiste("https://github.com/AFayez707")
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun viewWebiste(website: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website));
        startActivity(browserIntent);
    }

}