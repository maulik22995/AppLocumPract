package com.maulik.togadiya.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


data class AlbumData(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
) {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun ImageView.setImageUrl(url: String?) {
            Glide.with(context).asBitmap().load(url).into(this)
        }
    }
}