package com.mukeshsolanki.snake.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.presentation.theme.SnakeTheme
import com.mukeshsolanki.snake.presentation.theme.padding8dp

@Composable
fun DisplayLarge(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.displayLarge,
        textAlign = textAlign
    )
}

@Composable
fun TitleLarge(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        text = text,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.titleLarge,
        textAlign = textAlign
    )
}

@Composable
fun BodyLarge(modifier: Modifier = Modifier, text: String, textAlign: TextAlign = TextAlign.Start) {
    Text(
        modifier = modifier,
        text = text,
        color = MaterialTheme.colorScheme.primary,
        style = MaterialTheme.typography.bodyLarge,
        textAlign = textAlign
    )
}

@Preview
@Composable
private fun preview() {
    SnakeTheme {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DisplayLarge(
                modifier = Modifier.padding(padding8dp),
                text = stringResource(R.string.game_over),
                textAlign = TextAlign.Center
            )
            TitleLarge(
                modifier = Modifier.padding(padding8dp),
                text = stringResource(R.string.game_over),
                textAlign = TextAlign.Center
            )
            BodyLarge(
                modifier = Modifier.padding(padding8dp),
                text = stringResource(R.string.game_over),
                textAlign = TextAlign.Center
            )
        }
    }
}
