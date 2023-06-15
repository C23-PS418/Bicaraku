package com.projek.bicarakuu.fragment


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.projek.bicarakuu.AboutActivity
import com.projek.bicarakuu.HelpUsActivity
import com.projek.bicarakuu.HubungiActivity
import com.projek.bicarakuu.databinding.FragmentProfileBinding

class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.ivTentang.setOnClickListener {
            val intent = Intent(requireContext(), AboutActivity::class.java)
            intent.putExtra("EXTRA_DATA", "Data")
            startActivity(intent)
        }

        binding.ivBantuan.setOnClickListener {
            val intent = Intent(requireContext(), HelpUsActivity::class.java)
            intent.putExtra("EXTRA_DATA", "Data")
            startActivity(intent)
        }

        binding.ivHubungi.setOnClickListener {
            val intent = Intent(requireContext(), HubungiActivity::class.java)
            intent.putExtra("EXTRA_DATA", "Data")
            startActivity(intent)
        }

        return binding.root
    }
}