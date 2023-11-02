package com.example.movieapp.ui.components.dialog.components.content

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.em
import com.example.movieapp.ui.models.dialog.DialogContent
import com.example.movieapp.ui.models.dialog.DialogText
import com.example.movieapp.ui.theme.Paddings


data class DialogContentStyle(
    val textStyle: @Composable () -> TextStyle = { MaterialTheme.typography.body1 },
    val contentTopPadding: Dp = Paddings.xlarge,
    val contentBottomPadding: Dp = Paddings.extra
)

val LocalDialogContentStyle = compositionLocalOf { DialogContentStyle() }

@Composable
fun ColumnScope.DialogContentWrapper(content: DialogContent) {
    when (content) {
        is DialogContent.Defalut -> {
            CompositionLocalProvider(
                LocalDialogContentStyle provides DialogContentStyle(
                    textStyle = {
                        MaterialTheme.typography.body2.copy(
                            lineHeight = 1.6.em
                        )
                    },
                    contentTopPadding = Paddings.small,
                    contentBottomPadding = Paddings.extra
                )
            ) {
                NormalTextContent(content.dialogText)
            }
        }

        is DialogContent.Large -> {
            CompositionLocalProvider(
                LocalDialogContentStyle provides DialogContentStyle(
                    textStyle = {
                        MaterialTheme.typography.subtitle1.copy(
                            lineHeight = 1.6.em
                        )
                    },
                    contentTopPadding = Paddings.extra,
                    contentBottomPadding = Paddings.extra
                )
            ) {
                NormalTextContent(content.dialogText)
            }
        }

        is DialogContent.Rating -> {
            RatingContent(content.dialogText)
        }

    }
}

@Composable
fun ColumnScope.NormalTextContent(dialogText: DialogText.Default) {
    //왜 Text(text = dialogText.text)이렇게 안하는지??
    //나의 대답 null값이 들어올 수 있기 때문??
    Text(
        text = getStringFromDialogText(dialogText),
        modifier = Modifier
            .padding(
                top = LocalDialogContentStyle.current.contentTopPadding,
                bottom = LocalDialogContentStyle.current.contentBottomPadding
            )
            //현재 colunmScope인지 rowScope인지 알 수 없기 때문에 그냥 하면 오류
            //그래서 함수 앞에 ColumnScope라고 명시
            .align(Alignment.CenterHorizontally),
        //글자의 모양(정렬)
        textAlign = TextAlign.Center,
        //왜 invoke()??
        style = LocalDialogContentStyle.current.textStyle.invoke()
    )
}

@Composable
fun getStringFromDialogText(text: DialogText.Default): String =
    //dialogText는 text와 id를 받는데 두개다 nullable
    //그래서 둘 중에 하나가 null인지 아닌지 파악해서 int면 String으로 String이면 그대로
    text.id?.let { stringResource(id = it) } ?: text.text ?: ""


