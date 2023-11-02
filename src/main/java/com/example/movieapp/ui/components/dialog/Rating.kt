package com.example.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import com.example.movieapp.ui.models.dialog.DialogButton
import com.example.movieapp.ui.models.dialog.DialogContent
import com.example.movieapp.ui.models.dialog.DialogText
import com.example.movieapp.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons : List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Large("TITLE"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(text = movieName, rating = rating)
        ),
        buttons = buttons
    )
}