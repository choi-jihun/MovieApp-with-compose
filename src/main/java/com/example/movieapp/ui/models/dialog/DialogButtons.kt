package com.example.movieapp.ui.models.dialog

import com.example.movieapp.ui.models.button.LeadingIconData

//버튼에 따라 UI를 다르게
sealed class DialogButton(
    open val title: String,
    open val action: (() -> Unit)?
) {
    data class Primary(
        override val title: String,
        //why? 별점을 남길 때 SUBMIT 앞에 아이콘을 보여주기 위해서
        val leadingIconData: LeadingIconData? = null,
        override val action: (() -> Unit)? = null
    ) : DialogButton(title, action)

    data class Secondary(
        override val title: String,
        override val action: (() -> Unit)? = null
    ) : DialogButton(title, action)

    data class UnderlinedText(
        override val title: String,
        override val action: (() -> Unit)? = null
    ) : DialogButton(title, action)

    data class SecondaryBorderless(
        override val title: String,
        override val action: (() -> Unit)? = null
    ) : DialogButton(title, action)
}