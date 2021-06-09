package com.example.flickrapp.data.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val height: Int? = null,
    val id: String? = null,
    val url: String? = null,
    val width: Int? = null
): Parcelable