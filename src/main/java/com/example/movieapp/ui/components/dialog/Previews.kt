package com.example.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieapp.R
import com.example.movieapp.ui.models.button.LeadingIconData
import com.example.movieapp.ui.models.dialog.DialogButton
import com.example.movieapp.ui.theme.MovieAppTheme

@Preview
@Composable
fun AlertPreview() {
    MovieAppTheme {
        DialogPopup.Alert(
            title = "Title",
            bodyText = "blah blah blah",
            buttons = listOf(DialogButton.UnderlinedText("Okay") {})
        )

    }
}

@Preview
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        DialogPopup.Default(
            title = "Title",
            bodyText = "blah blah blah",
            buttons = listOf(
                DialogButton.Primary("Okay") {},
                DialogButton.SecondaryBorderless("CANCEL") {}
            )
        )

    }
}

@Preview
@Composable
fun RatingPreview() {
    MovieAppTheme {
        DialogPopup.Rating(
            movieName = "The Lord of the Rings",
            rating = 7.5f,
            buttons = listOf(
                DialogButton.Primary(
                    "Open",
                    leadingIconData = LeadingIconData(
                        R.drawable.ic_send,
                        iconContentDescription = null
                    )

                ) {},
            DialogButton.SecondaryBorderless("CANCEL"))
        )

    }
}