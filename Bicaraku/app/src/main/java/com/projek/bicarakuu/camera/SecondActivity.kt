package com.projek.bicarakuu.camera

import android.Manifest
import android.content.Intent
import android.content.Intent.ACTION_GET_CONTENT
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.projek.bicarakuu.R
import com.projek.bicarakuu.databinding.ActivitySecondBinding
import com.projek.bicarakuu.ml.Bicaraku
import com.projek.bicarakuu.camera.utils.TransformToGrayscaleOp
import com.projek.bicarakuu.camera.utils.rotateFile
import com.projek.bicarakuu.camera.utils.uriToFile
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    companion object {
        const val CAMERA_X_RESULT = 200
        private lateinit var labels: Array<String>
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (!allPermissionsGranted()) {
                Toast.makeText(
                    this,
                    "Tidak mendapatkan permission.",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }

    private fun loadLabels() {
        labels = arrayOf()
        var cnt = 0
        try {
            val bufferedReader = BufferedReader(InputStreamReader(assets.open("labels.txt")))
            var line = bufferedReader.readLine()
            while (line != null) {
                labels = labels.plus(line)
                cnt++
                line = bufferedReader.readLine()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(baseContext, it) == PackageManager.PERMISSION_GRANTED
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (!allPermissionsGranted()) {
            ActivityCompat.requestPermissions(
                this,
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        binding.cameraXButton.setOnClickListener { startCameraX() }
        binding.galleryButton.setOnClickListener { startGallery() }
        loadLabels()

    }

    private fun startCameraX() {
        val intent = Intent(this, CameraActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }

    private fun startGallery() {
        val intent = Intent()
        intent.action = ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val selectedImg = result.data?.data as Uri
            selectedImg.let { uri ->
                val myFile = uriToFile(uri, this@SecondActivity)
                binding.previewImageView.setImageURI(uri)
                val bitmap = BitmapFactory.decodeFile(myFile.path)
                outputGenerator(bitmap)
            }
        }
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
            val myFile = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.data?.getSerializableExtra("picture", File::class.java)
            } else {
                @Suppress("DEPRECATION")
                it.data?.getSerializableExtra("picture")
            } as? File

            val isBackCamera = it.data?.getBooleanExtra("isBackCamera", true) as Boolean

            myFile?.let { file ->
                rotateFile(file, isBackCamera)
                val bitmap = BitmapFactory.decodeFile(file.path)
                binding.previewImageView.setImageBitmap(bitmap)
                outputGenerator(bitmap)
            }
        }
    }

    private fun getMax(arr: FloatArray): Int {
        var max = 0
        for (i in arr.indices) {
            if (arr[i] > arr[max]) max = i
        }
        return max
    }

    private fun outputGenerator(bitmap: Bitmap) {
        val model = Bicaraku.newInstance(this)

        // Creates inputs for reference.

        // Creates inputs for reference.
        val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 50, 50, 1), DataType.FLOAT32)

        val newBitmap = Bitmap.createScaledBitmap(bitmap, 50, 50, true)
        val tensorImage = TensorImage(DataType.FLOAT32)
        tensorImage.load(newBitmap)

        val res = ResizeOp(50, 50, ResizeOp.ResizeMethod.BILINEAR)
        val res_res: TensorImage = res.apply(tensorImage)

        val tfg = TransformToGrayscaleOp()
        val tfg_tfg: TensorImage = tfg.apply(res_res)

        println(tfg_tfg.buffer)
        println(inputFeature0.buffer)

        val byteBuffer = tfg_tfg.buffer

        inputFeature0.loadBuffer(byteBuffer)

        // Runs model inference and gets result.
        val outputs = model.process(inputFeature0)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        binding.tvOutput.text =
            resources.getString(R.string.output_label, labels[getMax(outputFeature0.floatArray)])
        // Releases model resources if no longer used.
        model.close()

    }
}