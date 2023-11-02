package com.example.movieapp.ui.components.buttons

import android.support.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.Paddings
import com.example.movieapp.ui.theme.colorScheme

@Composable
fun SecondaryButton(
    modifier: Modifier = Modifier,
    @StringRes id: Int? = null,
    text: String = "",
    onCLick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onCLick,
        border = BorderStroke(2.dp, colorScheme.secondary),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorScheme.background,
            contentColor = colorScheme.secondary,
            disabledContentColor = colorScheme.background,
            disabledBackgroundColor = colorScheme.disabledSecondary
        ),
        elevation = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            //id가 비어있거나 없으면 text값을 표시
            Text(text = id?.let { stringResource(id = it) } ?: text,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(Paddings.small))
        }
    }
}

@Preview
@Composable
fun SecondaryButtonPreView() {
    MovieAppTheme() {
        SecondaryButton(text = "CANCEL") {

        }
    }
}