package com.example.flickrapp.data.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Height(
    val imperial: String,
    val metric: String
): Parcelable