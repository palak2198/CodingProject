package com.example.codingproject.view.profile

import android.os.Bundle
import android.view.LayoutInflater
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.codingproject.R
import com.example.codingproject.core.checkItem
import com.example.codingproject.core.getFragmentAtStackTop
import com.example.codingproject.databinding.ActivityProfileBinding
import com.example.codingproject.view.base.BaseActivity
import com.example.codingproject.view.cat.CatFragment

class ProfileActivity : BaseActivity<ActivityProfileBinding>() {

    override val bindingInflater: (LayoutInflater) -> ActivityProfileBinding
        get() = ActivityProfileBinding::inflate


//    private val navController by lazy {
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.home_fragment_container_view) as NavHostFragment
//
//        navHostFragment.navController
//    }

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var listener: NavController.OnDestinationChangedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController = findNavController(R.id.fragment)
        binding.navigationView.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(navController.graph, binding.drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
//        initNavigationGraph()
//        setUpNavigation()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

//    private fun initNavigationGraph() {
//        navController.setGraph(R.navigation.navigation, intent?.extras)
//    }
//
//    private fun setUpNavigation() {
//        binding.bottomNavigation.setOnItemSelectedListener {
//            handleMenuItemClickListener(it.itemId)
//        }
//        binding.bottomNavigation.checkItem(R.id.profileFragment)
//    }
//
//    private fun handleMenuItemClickListener(itemId: Int): Boolean {
//        when (itemId) {
//            R.id.profileFragment -> {
//                navController.popBackStack(R.id.profileFragment, false)
//                binding.bottomNavigation.checkItem(R.id.profileFragment)
//            }
//
//            R.id.catFragment -> {
//                navController.navigate(R.id.action_profileFragment_to_catFragment)
//                binding.bottomNavigation.checkItem(R.id.catFragment)
//            }
//        }
//        return true
//    }
//
//    override fun onBackPressed() {
//        handleBackPressed()
//    }
//
//    private fun handleBackPressed() {
//        when (supportFragmentManager.getFragmentAtStackTop()) {
//            is CatFragment -> {
//                binding.bottomNavigation.selectedItemId = R.id.profileFragment
//            }
//            else -> {
//                onBackPressedDispatcher.onBackPressed()
//            }
//        }
//    }
}