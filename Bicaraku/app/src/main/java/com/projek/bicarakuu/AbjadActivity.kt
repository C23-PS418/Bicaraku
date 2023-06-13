package com.projek.bicarakuu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.projek.bicarakuu.data.DataModel
import com.projek.bicarakuu.databinding.ActivityAbjadBinding
import com.projek.bicarakuu.fragment.ListAbjad

class AbjadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAbjadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbjadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(ListAbjad())

        val receivedData = intent.getParcelableExtra<DataModel>("data")
        if (receivedData != null) {
        }
    }


    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_Abjad,fragment)
        fragmentTransaction.commit()
    }
}
