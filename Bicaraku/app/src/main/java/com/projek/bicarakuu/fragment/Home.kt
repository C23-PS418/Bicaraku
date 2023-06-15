package com.projek.bicarakuu.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.projek.bicarakuu.AbjadActivity
import com.projek.bicarakuu.R
import com.projek.bicarakuu.adapter.SlideAdapter
import com.projek.bicarakuu.databinding.FragmentHomeBinding

class Home : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var vpSlider: ViewPager
    private lateinit var sliderHandler: Handler
    private lateinit var sliderRunnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val receivedData = arguments?.getString("data_home")
        if (receivedData != null) {
            // Do something with receivedData
        }

        binding.buttonAbjad.setOnClickListener {
            val intent = Intent(requireContext(), AbjadActivity::class.java)
            intent.putExtra("key_data", "data")
            startActivity(intent)
        }

        vpSlider = binding.vpSlider
        val arraySlide = ArrayList<Int>()
        arraySlide.add(R.drawable.slider_1)
        arraySlide.add(R.drawable.slider_2)
        val slideAdapter = SlideAdapter(arraySlide, requireActivity())
        vpSlider.adapter = slideAdapter

        // Automatic Slider
        sliderHandler = Handler(Looper.getMainLooper())
        sliderRunnable = Runnable {
            val currentPosition = vpSlider.currentItem
            val totalSlides = vpSlider.adapter?.count ?: 0
            val nextPosition = (currentPosition + 1) % totalSlides
            vpSlider.setCurrentItem(nextPosition, true)
            sliderHandler.postDelayed(sliderRunnable, 2000) // Ganti slide setiap 3 detik
        }
        sliderHandler.postDelayed(sliderRunnable, 2000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        sliderHandler.removeCallbacks(sliderRunnable)
    }

}