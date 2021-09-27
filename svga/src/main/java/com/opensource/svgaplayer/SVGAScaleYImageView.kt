package com.opensource.svgaplayer

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by neil on  2021/9/11
 */
open class SVGAScaleYImageView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : SVGAImageView(context, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val heightImage = MeasureSpec.getSize(heightMeasureSpec) * 2
        super.onMeasure(widthMeasureSpec, MeasureSpec.makeMeasureSpec(heightImage, MeasureSpec.EXACTLY))
    }
}