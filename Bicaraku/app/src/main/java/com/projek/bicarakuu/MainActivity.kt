package com.projek.bicarakuu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projek.bicarakuu.fragment.Home
import com.projek.bicarakuu.fragment.Profile
import androidx.fragment.app.Fragment
<<<<<<< HEAD
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.projek.bicarakuu.data.DataModel
=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
import com.projek.bicarakuu.databinding.ActivityMainBinding
import com.projek.bicarakuu.fragment.Terjemahan

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

<<<<<<< HEAD
        val receivedData = intent.getParcelableExtra<DataModel>("data")
        if (receivedData != null) {
        }

        val navView: BottomNavigationView = binding.bottomNavigationView
        navView.itemIconTintList = null

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
=======
        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    menuItem.setIcon(R.drawable.selector_home)
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
                    replaceFragment(Home())
                    true
                }
                R.id.terjemahan -> {
<<<<<<< HEAD
                    replaceFragment(Terjemahan())
                    true
                }
                R.id.setting -> {
=======
                    menuItem.setIcon(R.drawable.selector_terjemahan)
                    replaceFragment(Terjemahan())
                    true
                }
                R.id.profile -> {
                    menuItem.setIcon(R.drawable.selector_profile)
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
                    replaceFragment(Profile())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()
    }
}