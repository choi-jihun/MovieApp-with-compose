package com.example.movieapp.ui.components.dialog.components.content

import android.content.res.ColorStateList
import android.widget.RatingBar
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import com.example.movieapp.ui.models.dialog.DialogText
import com.example.movieapp.ui.theme.Paddings
import com.example.movieapp.ui.util.getAnnotatedText

@Composable
fun RatingContent(content: DialogText.Rating) {
    Column(
        modifier = Modifier.padding(
            top = Paddings.large,
            bottom = Paddings.xlarge
        )
    ) {
        RatingTable(
            rating = content.rating,
            movieTitle = content.text ?: ""
        )
    }
}

@Composable
fun ColumnScope.RatingTable(
    rating: Float,
    movieTitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.CenterHorizontally)
    ) {
        //영화 제목
        Text(
            modifier = Modifier.align(
                Alignment.CenterHorizontally
            ),
            text = getAnnotatedText(text = movieTitle),
            style = MaterialTheme.typography.subtitle1.copy(
                color = MaterialTheme.colors.secondary
            ),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(Paddings.large))
        //별점
        StarRatingBar(
            score = rating
        )
    }
}

@Composable
fun ColumnScope.StarRatingBar(score: Float) {
    Card(
        modifier = androidx.compose.ui.Modifier
            .padding(
                Paddings.medium
            )
            .wrapContentSize()
            .align(Alignment.CenterHorizontally),
        elevation = Paddings.none
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            val foregroundColor = MaterialTheme.colors.primary.toArgb()
            val starBackgroundColor = MaterialTheme.colors.primaryVariant.copy(
                alpha = 0.2f
            ).toArgb()
            val ratingBackgroundColor = MaterialTheme.colors.primaryVariant.copy(
                alpha = 0.05f
            ).toArgb()

            //AndroidView는 기존 jetpackcompose로 만들어지지않은 기존 안드로이드 뷰 혹은 클래스를
            //jetpackcompose에서 보여질 수 있게
            AndroidView(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.Center),
                factory = {
                    RatingBar(
                        it
                    ).apply {
                        max = 10
                        stepSize = 25f
                        rating = score
                        numStars = 5
                        progressTintList = ColorStateList.valueOf(foregroundColor)
                        progressBackgroundTintList = ColorStateList.valueOf(starBackgroundColor)
                        setBackgroundColor(ratingBackgroundColor)
                    }
                }
                //update는 레이아웃이 inflate될때 마다 불려짐, 잘 안쓰는게 좋음
            )
        }
    }
}