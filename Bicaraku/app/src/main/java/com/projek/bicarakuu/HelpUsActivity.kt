package com.projek.bicarakuu

import android.graphics.Color
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.projek.bicarakuu.databinding.ActivityHelpUsBinding

class HelpUsActivity: AppCompatActivity() {

    private lateinit var binding: ActivityHelpUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelpUsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val extraData = intent.getStringExtra("EXTRA_DATA")
        if (extraData != null) {
            // Lakukan sesuatu dengan extraData jika diperlukan
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val title = "Bantuan"
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

        val editTextDeskripsi: EditText = findViewById(R.id.editText_deskripsi)
        editTextDeskripsi.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val input = s.toString().trim()
                val words = input.split("\\s+".toRegex()).size

                if (words > 300) {
                    val trimmedInput = input.split("\\s+".toRegex()).take(300).joinToString(" ")
                    editTextDeskripsi.setText(trimmedInput)
                    editTextDeskripsi.setSelection(trimmedInput.length)
                    Toast.makeText(this@HelpUsActivity, "Deskripsi terbatas hingga 300 kata", Toast.LENGTH_SHORT).show()
                }
            }
        })

        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            val editTextNama: EditText = findViewById(R.id.editText_nama)
            val editTextEmail: EditText = findViewById(R.id.editText_email)
            val editTextDeskripsi: EditText = findViewById(R.id.editText_deskripsi)

            val nama = editTextNama.text.toString().trim()
            val email = editTextEmail.text.toString().trim()
            val deskripsi = editTextDeskripsi.text.toString().trim()

            if (nama.isEmpty() || email.isEmpty() || deskripsi.isEmpty()) {
                Toast.makeText(this, "Mohon lengkapi semua bidang yang wajib diisi", Toast.LENGTH_SHORT).show()
            } else {
            }
        }
    }
}