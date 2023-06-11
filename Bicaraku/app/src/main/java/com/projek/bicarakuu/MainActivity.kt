package com.projek.bicarakuu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projek.bicarakuu.fragment.Home
import com.projek.bicarakuu.fragment.Profile
import androidx.fragment.app.Fragment
import com.projek.bicarakuu.databinding.ActivityMainBinding
import com.projek.bicarakuu.fragment.Terjemahan

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    menuItem.setIcon(R.drawable.selector_home)
                    replaceFragment(Home())
                    true
                }
                R.id.terjemahan -> {
                    menuItem.setIcon(R.drawable.selector_terjemahan)
                    replaceFragment(Terjemahan())
                    true
                }
                R.id.profile -> {
                    menuItem.setIcon(R.drawable.selector_profile)
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