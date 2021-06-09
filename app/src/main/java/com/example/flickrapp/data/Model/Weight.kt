package com.example.flickrapp.data.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Weight(
    val imperial: String? = null,
    val metric: String? = null
): Parcelable