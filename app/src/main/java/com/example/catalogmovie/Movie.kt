package com.example.catalogmovie

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val year: String,
    val rate: String,
    val duration: String,
    val description: String,
    val cover: Int
): Parcelable
