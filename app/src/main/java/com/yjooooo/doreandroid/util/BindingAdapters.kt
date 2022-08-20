package com.yjooooo.doreandroid.util

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yjooooo.doreandroid.R

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("profileImgUri")
    fun setProfileImg(imageview: ImageView, imgUri: String?) {
        if (imgUri == null) {
            Glide.with(imageview.context)
                .load(R.drawable.shape_circle_black)
                .placeholder(R.drawable.shape_circle_black)
                .error(R.drawable.shape_circle_black)
                .circleCrop()
                .into(imageview)
        } else {
            Glide.with(imageview.context)
                .load(imgUri)
                .placeholder(R.drawable.shape_circle_black)
                .error(R.drawable.shape_circle_black)
                .circleCrop()
                .into(imageview)
        }
    }

    @JvmStatic
    @BindingAdapter("imageUri")
    fun setImage(imageview: ImageView, url: String?) {
        url?.let {
            Glide.with(imageview.context)
                .load(url)
                .placeholder(R.color.dore_black)
                .error(R.color.dore_black)
                .into(imageview)
        }
    }
}
