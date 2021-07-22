package com.uninet.ufresh.util

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.renderscript.Allocation
import android.renderscript.Element
import android.renderscript.RenderScript
import android.renderscript.ScriptIntrinsicBlur

class BlurBuilder {
    val BITMAP_SCALE : Float = 0.4f
    var BLUR_RADIUS : Float = 5.1f


    fun blur(context: Context, image:Bitmap,blur_radius:Float):Bitmap{

        this.BLUR_RADIUS = blur_radius
        var width = Math.round(image.width.toFloat() * BITMAP_SCALE )
        var height = Math.round(image.height.toFloat() * BITMAP_SCALE )

        var inputbitmap : Bitmap = Bitmap.createScaledBitmap(image,width,height,false)
        var outputbitmap : Bitmap = Bitmap.createBitmap(inputbitmap)

        var rs : RenderScript = RenderScript.create(context)
        var sib : ScriptIntrinsicBlur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs))
        var imgIn : Allocation = Allocation.createFromBitmap(rs,inputbitmap)
        var imgOut : Allocation = Allocation.createFromBitmap(rs,outputbitmap)
        sib.setRadius(BLUR_RADIUS)
        sib.setInput(imgIn)
        sib.forEach(imgOut)
        imgOut.copyTo(outputbitmap)

        return outputbitmap
    }

}

