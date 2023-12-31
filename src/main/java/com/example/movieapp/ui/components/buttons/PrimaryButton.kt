package com.example.movieapp.ui.components.buttons

import android.support.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.ui.models.button.LeadingIconData
import com.example.movieapp.ui.theme.MovieAppTheme
import com.example.movieapp.ui.theme.Paddings
import com.example.movieapp.ui.theme.colorScheme

val LEADING_ICON_SIZE = 24.dp

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier,
    //Resource ID를 보냄 ex)R.Strings.app_name 이런 식으로
    @StringRes id: Int? = null,
    text: String = "",
    leadingIconData: LeadingIconData? = null,
    onCLick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onCLick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorScheme.primary,
            contentColor = colorScheme.onPrimary,
            disabledContentColor = colorScheme.background,
            disabledBackgroundColor = colorScheme.disabledSecondary
        ),
        elevation = null
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIconData?.let {
                Icon(
                    modifier = Modifier.size(LEADING_ICON_SIZE),
                    painter = painterResource(id = leadingIconData.iconDrawable),
                    contentDescription = leadingIconData.iconContentDescription?.let { icon ->
                        stringResource(
                            id = icon
                        )
                    }
                )
                Spacer(modifier = Modifier.padding(Paddings.small))
            }
            //id가 비어있거나 없으면 text값을 표시
            Text(text = id?.let { stringResource(id = it) } ?: text,
                style = MaterialTheme.typography.button,
                modifier = Modifier.padding(Paddings.small))
        }
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    MovieAppTheme() {
        PrimaryButton(text = "SUBMIT") {

        }
    }
}