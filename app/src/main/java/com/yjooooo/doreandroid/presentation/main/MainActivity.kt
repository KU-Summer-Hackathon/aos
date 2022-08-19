package com.yjooooo.doreandroid.presentation.main

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.yjooooo.doreandroid.R
import com.yjooooo.doreandroid.databinding.ActivityMainBinding
import com.yjooooo.doreandroid.presentation.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {
        val navController = findNavController()
        binding.bottomNaviMain.setupWithNavController(navController)
    }

    private fun findNavController(): NavController {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        return navHostFragment.navController
    }
}
