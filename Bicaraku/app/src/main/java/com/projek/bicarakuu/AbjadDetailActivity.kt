package com.projek.bicarakuu

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
import com.projek.bicarakuu.databinding.ActivityAbjadDetailBinding

class AbjadDetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAbjadDetailBinding

    private lateinit var loadingAnimationView: LottieAnimationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbjadDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        }

    }



}