package com.example.movieapp.ui.models.dialog

//Content는 보여주는 방식
sealed class DialogContent {
    data class Defalut(
        val dialogText: DialogText.Default
    ): DialogContent()

    data class Large(
        val dialogText: DialogText.Default
    ): DialogContent()

    data class Rating(
        val dialogText: DialogText.Rating
    ): DialogContent()
}
