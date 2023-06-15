package com.projek.bicarakuu.fragment


<<<<<<< HEAD
import android.content.Intent
=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
<<<<<<< HEAD
import com.projek.bicarakuu.AboutActivity
import com.projek.bicarakuu.HelpUsActivity
import com.projek.bicarakuu.HubungiActivity
import com.projek.bicarakuu.databinding.FragmentProfileBinding

=======
import com.projek.bicarakuu.databinding.FragmentProfileBinding


>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
<<<<<<< HEAD

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

=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
        return binding.root
    }
}