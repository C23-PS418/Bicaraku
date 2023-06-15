package com.projek.bicarakuu

<<<<<<< HEAD
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.TypedValue
import android.view.Gravity
import android.view.RoundedCorner
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.airbnb.lottie.LottieAnimationView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.projek.bicarakuu.data.DataModel
=======
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.projek.bicarakuu.adapter.ImageSliderAdapter
import com.projek.bicarakuu.data.ImageData
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
import com.projek.bicarakuu.databinding.ActivityAbjadDetailBinding

class AbjadDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAbjadDetailBinding
<<<<<<< HEAD

    private lateinit var loadingAnimationView: LottieAnimationView

=======
    private lateinit var adapter: ImageSliderAdapter
    private val list = ArrayList<ImageData>()
    private lateinit var dots: ArrayList<TextView>
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbjadDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

<<<<<<< HEAD
        loadingAnimationView = findViewById(R.id.loadingAnimationView)

        loadingAnimationView.playAnimation()
        binding.nmAbjad.visibility = View.GONE
        binding.detailGambar.visibility = View.GONE


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        val title = "Abjad"
        supportActionBar?.title = title

        val toolbarTitle = toolbar.getChildAt(0) as? TextView
        val customColor = Color.parseColor("#27374D")
        toolbarTitle?.let {
            it.gravity = Gravity.CENTER
            val params = Toolbar.LayoutParams(
                Toolbar.LayoutParams.WRAP_CONTENT,
                Toolbar.LayoutParams.WRAP_CONTENT
            )
            params.gravity = Gravity.CENTER
            it.layoutParams = params

            it.setTextColor(customColor)
        }

        toolbarTitle?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
        toolbar.navigationIcon?.setColorFilter(customColor, PorterDuff.Mode.SRC_ATOP)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val dataModel : DataModel? = intent.getParcelableExtra("data")
        if (dataModel != null) {
            val huruf = dataModel.huruf
            val photo = dataModel.photo

            Handler(Looper.getMainLooper()).postDelayed({
                loadingAnimationView.cancelAnimation()
                loadingAnimationView.visibility = View.GONE

                binding.nmAbjad.text = huruf
                Glide.with(this)
                    .load(photo)
                    .transform(MultiTransformation(CenterCrop(), RoundedCorners(70)))
                    .into(binding.detailGambar)

                binding.nmAbjad.visibility = View.VISIBLE
                binding.detailGambar.visibility = View.VISIBLE
            }, 3000)
=======
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
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
        }

    }

<<<<<<< HEAD

=======
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
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca

}