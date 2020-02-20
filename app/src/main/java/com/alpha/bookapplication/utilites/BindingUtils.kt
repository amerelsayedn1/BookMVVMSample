package com.alpha.bookapplication.utilites

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.alpha.bookapplication.R
import com.bumptech.glide.Glide


object BindingUtils {

    @BindingAdapter("bind:src")
    @JvmStatic
    fun setimgresource(view: ImageView, url: String?) {
        Glide.with(view.context).load("https://amayei.nyc3.digitaloceanspaces.com/2019/09/Heart-Disease.jpeg").placeholder(R.drawable.bg).into(view)
    }

}