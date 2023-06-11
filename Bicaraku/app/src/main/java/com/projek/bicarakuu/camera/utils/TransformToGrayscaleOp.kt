package com.projek.bicarakuu.camera.utils

import android.graphics.*
import org.tensorflow.lite.support.common.SupportPreconditions
import org.tensorflow.lite.support.image.ColorSpaceType
import org.tensorflow.lite.support.image.ImageOperator
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class TransformToGrayscaleOp
    : ImageOperator {

    override fun apply(image: TensorImage): TensorImage {
        if (image.colorSpaceType === ColorSpaceType.GRAYSCALE) {
            return image
        } else {
            SupportPreconditions.checkArgument(
                image.colorSpaceType === ColorSpaceType.RGB,
                "Only RGB images are supported in TransformToGrayscaleOp, but not "
                        + image.colorSpaceType.name
            )
        }
        val h = image.height
        val w = image.width
        val bmpGrayscale = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmpGrayscale)
        val paint = Paint()
        val colorMatrixFilter = ColorMatrixColorFilter(BITMAP_RGBA_GRAYSCALE_TRANSFORMATION)
        paint.colorFilter = colorMatrixFilter
        canvas.drawBitmap(image.bitmap, 0.0f, 0.0f, paint)

        val intValues = IntArray(w * h)
        bmpGrayscale.getPixels(intValues, 0, w, 0, 0, w, h)

        val shape = intArrayOf(1, h, w, 1)

        for (i in intValues.indices) {
            intValues[i] = intValues[i] shr 16 and 0xff

        }
        val buffer = TensorBuffer.createFixedSize(shape, image.dataType)
        buffer.loadArray(intValues, shape)
        image.load(buffer, ColorSpaceType.GRAYSCALE)
        return image
    }

    override fun getOutputImageHeight(inputImageHeight: Int, inputImageWidth: Int): Int {
        return inputImageHeight
    }

    override fun getOutputImageWidth(inputImageHeight: Int, inputImageWidth: Int): Int {
        return inputImageWidth
    }

    override fun inverseTransform(
        point: PointF,
        inputImageHeight: Int,
        inputImageWidth: Int
    ): PointF {
        return point
    }

    companion object {

        private val BITMAP_RGBA_GRAYSCALE_TRANSFORMATION = floatArrayOf(
            0.299f,
            0.587f,
            0.114f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            0.0f,
            1.0f,
            0.0f
        )
    }
}