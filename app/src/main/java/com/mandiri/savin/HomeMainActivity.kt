package com.mandiri.savin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mandiri.savin.databinding.HomeMainActivityBinding
import com.mandiri.savin.presentation.view.fragment.HistoryFragment
import com.mandiri.savin.presentation.view.fragment.EwalletFragment
import com.mandiri.savin.presentation.view.fragment.HomeFragment
import com.mandiri.savin.presentation.view.fragment.SettingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeMainActivity : AppCompatActivity() {
    private lateinit var binding: HomeMainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeMainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigateItemSelectedListener)
        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId =
                R.id.navigationHome
        }
    }

    private val onNavigateItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    item.setIcon(R.drawable.ic_home_color)
                    resetToDefaultIcons()
                    replaceFragment(HomeFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationEwallet -> {
                    item.setIcon(R.drawable.ic_wallet_color)
                    resetToDefaultIcons()
                    replaceFragment(EwalletFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationHistory -> {
                    item.setIcon(R.drawable.ic_activity_color)
                    resetToDefaultIcons()
                    replaceFragment(HistoryFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationSetting -> {
                    item.setIcon(R.drawable.ic_settings_color)
                    resetToDefaultIcons()
                    replaceFragment(SettingFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmenContainer, fragment)
            .commit()
    }

    private fun resetToDefaultIcons() {
        val menu = binding.bottomNavigation.menu
        menu.findItem(R.id.navigationHome).setIcon(R.drawable.ic_home)
        menu.findItem(R.id.navigationEwallet).setIcon(R.drawable.ic_wallet)
        menu.findItem(R.id.navigationHistory).setIcon(R.drawable.ic_activity)
        menu.findItem(R.id.navigationSetting).setIcon(R.drawable.ic_settings)
    }

}