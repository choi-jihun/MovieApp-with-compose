package com.example.movieapp.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.Paddings

@Composable
fun CategoryRow() {
    Column() {
        CategoryTitle("Actions")
        //바로 10.dp이런식으로 넣으면 안됨
        LazyRow(contentPadding = PaddingValues(horizontal = Paddings.large)) {
//            itemsIndexed()
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
        }
    }
}

@Composable
fun CategoryTitle(s: String) {
    Text(
        text = "Action",
        modifier = Modifier.padding(
            vertical = Paddings.large,
            horizontal = Paddings.extra
        ),
        style = MaterialTheme.typography.h5
    )
}

@Preview
@Composable
fun CategoryRowPreview() {
    MovieAppTheme() {
        CategoryRow()
    }
}
