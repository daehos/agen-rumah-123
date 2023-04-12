package com.dicoding.agenrumah123

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class House (
    val photo: Int,
    val name: String,
    val description: String,
    val harga: String,
    val deskripsi: String,

    ) : Parcelable

//@Parcelize
//data class House (
//    val photo: Int,
//    val harga: String,
//    val name: String,
//    val description: String,
//    val deskripsi: String,
//
//    ) : Parcelable
