package com.projek.bicarakuu

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.projek.bicarakuu.adapter.ImageSliderAdapter
import com.projek.bicarakuu.data.ImageData
import com.projek.bicarakuu.databinding.ActivityAbjadDetailBinding

class AbjadDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAbjadDetailBinding
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots: ArrayList<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbjadDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.add(
            ImageData(
                ""
            )
        )

        adapter = ImageSliderAdapter(list)
        binding.viewPager.adapter = adapter
        dots = ArrayList()
        setIndicator()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                selectedDot(position)
                super.onPageSelected(position)
            }
        })
    }

    private fun selectedDot(position: Int) {

        for(i in 0 until list.size){
            if (i == position)
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.dark_blue))
            else
                dots[i].setTextColor(ContextCompat.getColor(this, R.color.light_purple))
        }

    }

    private fun setIndicator() {
        for (i in 0 until list.size){
            dots.add(TextView(this))
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                dots[i].text = Html.fromHtml("&#9679", Html.FROM_HTML_MODE_LEGACY).toString()
            } else {
                dots[i].text = Html.fromHtml("&#9679")
            }
            dots[i].textSize = 18f
            binding.dotsIndicator.addView(dots[i])
        }
    }

}