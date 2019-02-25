package com.techbeloved.hymnbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.get
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.techbeloved.hymnbook.databinding.ActivityHymnbookBinding

class HymnbookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHymnbookBinding
    private lateinit var navController: NavController

    private lateinit var viewModel: HymnbookViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hymnbook)

        navController = findNavController(R.id.mainNavHostFragment)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.bottomNavigationMain.setupWithNavController(navController)
        //binding.toolbarMain.setupWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            // Hide the bottom navigation in detail view
            if (destination.id == R.id.detailPagerFragment) {
                if (binding.bottomNavigationMain.isVisible) binding.bottomNavigationMain.visibility = View.INVISIBLE
            } else {
                if (!binding.bottomNavigationMain.isVisible) binding.bottomNavigationMain.visibility = View.VISIBLE
            }
        }

        // setup the shared viewmodel
        viewModel = ViewModelProviders.of(this).get(HymnbookViewModel::class.java)
        //viewModel.toolbarTitle.observe(this, Observer { updateToolbarTitle(it) })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_nav, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    private fun updateToolbarTitle(title: String) {
        //binding.toolbarMain.title = title
    }
}
