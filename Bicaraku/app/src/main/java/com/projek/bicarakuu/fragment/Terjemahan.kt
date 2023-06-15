package com.projek.bicarakuu.fragment

import android.Manifest
import android.app.Activity
<<<<<<< HEAD
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
=======
import android.content.Intent
import android.content.pm.PackageManager
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
<<<<<<< HEAD
import android.os.Handler
import android.os.Looper
=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
<<<<<<< HEAD
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.snackbar.Snackbar
import com.projek.bicarakuu.R
import com.projek.bicarakuu.camera.CameraActivity
import com.projek.bicarakuu.camera.SecondActivity
import com.projek.bicarakuu.camera.utils.TransformToGrayscaleOp
import com.projek.bicarakuu.camera.utils.rotateFile
import com.projek.bicarakuu.camera.utils.uriToFile
import com.projek.bicarakuu.databinding.FragmentTerjemahanBinding
import com.projek.bicarakuu.ml.Bicaraku
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader


class Terjemahan : Fragment() {
    private var _binding: FragmentTerjemahanBinding? = null
    private lateinit var loadingAnimationView: LottieAnimationView
=======
import com.projek.bicarakuu.R
import com.projek.bicarakuu.camera.CameraActivity
import com.projek.bicarakuu.camera.SecondActivity
import com.projek.bicarakuu.camera.utils.rotateFile
import com.projek.bicarakuu.camera.utils.uriToFile
import com.projek.bicarakuu.databinding.FragmentTerjemahanBinding
import java.io.File


class Terjemahan : Fragment() {
   private var _binding: FragmentTerjemahanBinding? = null
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
    private val binding get() = _binding!!

    companion object {
        const val CAMERA_X_RESULT = 200
        private lateinit var labels: Array<String>
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
        private const val REQUEST_CODE_PERMISSIONS = 10
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTerjemahanBinding.inflate(inflater, container, false)
        return binding.root
<<<<<<< HEAD

=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
<<<<<<< HEAD
        loadingAnimationView = binding.loadingAnimationView
=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
        if (!allPermissionsGranted()) {
            requestPermissions(
                REQUIRED_PERMISSIONS,
                REQUEST_CODE_PERMISSIONS
            )
        }
        binding.tkCamButton.setOnClickListener { startCameraX() }
        binding.GaleryButton.setOnClickListener { startGallery() }
<<<<<<< HEAD
        loadLabels()
=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
    }

    private fun startCameraX() {
        val intent = Intent(requireContext(), CameraActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }

    private fun startGallery() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        val chooser = Intent.createChooser(intent, "Choose a Picture")
        launcherIntentGallery.launch(chooser)
    }

    private val launcherIntentGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
<<<<<<< HEAD

=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
            val selectedImg = result.data?.data as Uri
            selectedImg.let { uri ->
                val myFile = uriToFile(uri, requireContext())
                val bitmap = BitmapFactory.decodeFile(myFile.path)

<<<<<<< HEAD
                binding.previewImageView.setImageBitmap(bitmap)
                outputGenerator(bitmap)
//                val intent = Intent(requireContext(), SecondActivity::class.java)
//                intent.putExtra("bitmap", bitmap)
//                startActivity(intent)
=======
                val intent = Intent(requireContext(), SecondActivity::class.java)
                intent.putExtra("bitmap", bitmap)
                startActivity(intent)
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
            }
        }
    }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERA_X_RESULT) {
<<<<<<< HEAD

=======
>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
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
<<<<<<< HEAD
                binding.previewImageView.setImageBitmap(bitmap)
                outputGenerator(bitmap)
//                val intent = Intent(requireContext(), SecondActivity::class.java)
//                intent.putExtra("bitmap", bitmap)
//                startActivity(intent)
            }
        }
    }
    private fun getContextFromFragment(): Context? {
        return activity?.applicationContext
    }

    private fun loadLabels() {
        labels = arrayOf()
        var cnt = 0
        try {
            val context = getContextFromFragment()
            context?.assets?.open("labels.txt")?.use { inputStream ->
                val bufferedReader = BufferedReader(InputStreamReader(inputStream))
                var line = bufferedReader.readLine()
                while (line != null) {
                    labels = labels.plus(line)
                    cnt++
                    line = bufferedReader.readLine()
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
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

        binding.previewImageView.visibility = View.GONE
        binding.GaleryButton.visibility = View.GONE
        binding.tkCamButton.visibility = View.GONE

        loadingAnimationView.visibility = View.VISIBLE
        loadingAnimationView.playAnimation()

        val model = Bicaraku.newInstance(requireContext())

        val animationDuration = 3000L
        Handler(Looper.getMainLooper()).postDelayed({
            loadingAnimationView.cancelAnimation()
            loadingAnimationView.visibility = View.GONE

            binding.previewImageView.visibility = View.VISIBLE
            binding.GaleryButton.visibility = View.VISIBLE
            binding.tkCamButton.visibility = View.VISIBLE

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

        val output = labels[getMax(outputFeature0.floatArray)]
        Snackbar.make(binding.root, "Hasil: $output", Snackbar.LENGTH_SHORT)
            .setAction("tutup") {

                // Logika yang dijalankan saat tombol di-dismiss ditekan
                binding.previewImageView.setImageResource(R.drawable.anim_ter)

                // Menghentikan animasi loading dan mengubah visibilitasnya menjadi GONE
                loadingAnimationView.cancelAnimation()
                loadingAnimationView.visibility = View.GONE
            }
            .show()

        // Releases model resources if no longer used.
        model.close()

    }, animationDuration)

    }
=======

                val intent = Intent(requireContext(), SecondActivity::class.java)
                intent.putExtra("bitmap", bitmap)
                startActivity(intent)
            }
        }
    }

>>>>>>> 44ee652983da6571bee00978e1fa447dc086feca
}