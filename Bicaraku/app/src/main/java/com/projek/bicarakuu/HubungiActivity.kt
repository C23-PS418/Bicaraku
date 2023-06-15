package com.projek.bicarakuu

import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.projek.bicarakuu.databinding.ActivityHubungiBinding

class HubungiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHubungiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHubungiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val title = "Hubungi"
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

        val imageViewHubungiMail = findViewById<ImageView>(R.id.iv_hubungi_mail)
        imageViewHubungiMail.setOnClickListener {
            val recipientEmail = "bicaraku2023@gmail.com"
            val subject = "Subjek Email"
            val message = "Isi pesan email"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, message)

            val chooserIntent = Intent.createChooser(intent, "Pilih Aplikasi Email")

            if (intent.resolveActivity(packageManager) != null) {
                startActivity(chooserIntent)
            } else {
                Toast.makeText(this, "Tidak ada aplikasi email yang terpasang", Toast.LENGTH_SHORT).show()
            }
        }
    }
}