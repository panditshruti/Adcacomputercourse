package com.shrutipandit.computercourse

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.shrutipandit.computercourse.databinding.ActivityMainBinding

  class MainActivity : AppCompatActivity() {
      private lateinit var binding: ActivityMainBinding
      private lateinit var navController: NavController
      private lateinit var appBarConfiguration: AppBarConfiguration


      @SuppressLint("SuspiciousIndentation")
      override fun onCreate(savedInstanceState: Bundle?) {
          super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
          setContentView(binding.root)
          setSupportActionBar(binding.toolbar)


          val navHostFragment =
              supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
          navController = navHostFragment.navController

          appBarConfiguration = AppBarConfiguration(
              setOf(
                  R.id.home2,
                  R.id.chapterDetailsFragment,
                  R.id.videos,
                  R.id.certificate,
                  R.id.setting
              )
          )
          binding.toolbar.setupWithNavController(navController, appBarConfiguration)
          binding.bottomNevigation.setupWithNavController(navController)

      }


      override fun onCreateOptionsMenu(menu: Menu?): Boolean {
          menuInflater.inflate(R.menu.toolbar_menu, menu)
          return true
      }

      override fun onOptionsItemSelected(item: MenuItem): Boolean {
          return when (item.itemId) {
              R.id.aboutUs -> {
                  Toast.makeText(this, "Clicked on About Us page", Toast.LENGTH_SHORT).show()
                  true
              }

              R.id.setting -> {
                  Toast.makeText(this, "Clicked on Setting page", Toast.LENGTH_SHORT).show()
                  true
              }

              else -> super.onOptionsItemSelected(item)
          }

      }
  }
