package com.projek.bicarakuu.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projek.bicarakuu.AbjadActivity
import com.projek.bicarakuu.KataActivity
import com.projek.bicarakuu.databinding.FragmentHomeBinding

class Home : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receivedData = arguments?.getString("data_home")
        if (receivedData != null) {
        }

        binding.buttonAbjad.setOnClickListener {
            val intent = Intent(requireContext(), AbjadActivity::class.java)
            intent.putExtra("key_data", "data")
            startActivity(intent)
        }

        binding.buttonKata.setOnClickListener {
            val intent = Intent(requireContext(), KataActivity::class.java)
            intent.putExtra("key_data", "data")
            startActivity(intent)
        }
    }
}