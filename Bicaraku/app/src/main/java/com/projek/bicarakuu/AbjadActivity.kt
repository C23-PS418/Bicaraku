package com.projek.bicarakuu

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
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

    }
    
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_Abjad,fragment)
        fragmentTransaction.commit()
    }

}
