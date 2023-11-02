package com.example.movieapp.ui.components.dialog.components.title

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.movieapp.ui.models.dialog.DialogTitle
import com.example.movieapp.ui.theme.H5Title
import com.example.movieapp.ui.theme.Paddings
import com.example.movieapp.ui.theme.colorScheme

@Composable
fun DialogTitleWrapper(title: DialogTitle) {
    when (title) {
        is DialogTitle.Default -> {
            DefaultDialogTitle(title)
        }
        is DialogTitle.Header -> {
            HeaderDialogTitle(title)
        }

        is DialogTitle.Large -> {
            LargeDialogTitle(title)
        }
    }
}

@Composable
fun LargeDialogTitle(title: DialogTitle.Large) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title.text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = Paddings.xlarge)
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.H5Title,
            color = colorScheme.secondary
        )
    }
}

@Composable
fun HeaderDialogTitle(title: DialogTitle.Header) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.primary)
            .padding(all = Paddings.large),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title.text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3.copy(
                color = colorScheme.onPrimary
            )
        )
    }
}

@Composable
fun DefaultDialogTitle(title: DialogTitle.Default) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorScheme.onPrimary)
            .padding(
                horizontal = Paddings.large,
                vertical = Paddings.extra
            ),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title.text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5.copy(
                color = colorScheme.secondary
            )
        )
    }
}
