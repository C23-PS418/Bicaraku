package com.projek.bicarakuu

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.projek.bicarakuu.databinding.ActivityAbjadBinding
import com.projek.bicarakuu.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val extraData = intent.getStringExtra("EXTRA_DATA")
        if (extraData != null) {
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val title = "Tentang"
        supportActionBar?.title = title

        val toolbarTitle = toolbar.getChildAt(0) as? TextView
        val customColor = Color.parseColor("#27374D")
        toolbarTitle?.let {
            it.gravity = Gravity.CENTER_HORIZONTAL
            val params = Toolbar.LayoutParams(
                Toolbar.LayoutParams.WRAP_CONTENT,
                Toolbar.LayoutParams.WRAP_CONTENT
            )
            params.gravity = Gravity.CENTER_HORIZONTAL
            it.layoutParams = params

            it.setTextColor(customColor)
        }

        toolbarTitle?.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24f)
        toolbar.navigationIcon?.setColorFilter(customColor, PorterDuff.Mode.SRC_ATOP)

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }
    }
}