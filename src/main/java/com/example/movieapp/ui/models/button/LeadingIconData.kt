package com.example.movieapp.ui.models.button

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes

data class LeadingIconData(
    //Drawable의 id를 가져옴 ex)R.drawable.blabla
    @DrawableRes val iconDrawable: Int,
    @StringRes val iconContentDescription: Int?
)
