package com.example.lesson12

import android.icu.text.CaseMap
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class DataClass (
    var title: String,
    var title1: String
): Parcelable