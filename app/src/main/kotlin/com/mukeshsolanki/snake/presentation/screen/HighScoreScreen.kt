package com.mukeshsolanki.snake.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.data.cache.GameCache
import com.mukeshsolanki.snake.data.model.HighScore
import com.mukeshsolanki.snake.domain.base.TOP_10
import com.mukeshsolanki.snake.presentation.component.AppBar
import com.mukeshsolanki.snake.presentation.component.BodyLarge
import com.mukeshsolanki.snake.presentation.theme.SnakeTheme
import com.mukeshsolanki.snake.presentation.theme.border2dp
import com.mukeshsolanki.snake.presentation.theme.padding16dp

@Composable
fun HighScoreScreen(navController: NavHostController) {
    val dataStore = GameCache(LocalContext.current)
    val highScores =
        dataStore.getHighScores.collectAsState(initial = listOf()).value.sortedByDescending { it.score }
            .take(TOP_10)
    AppBar(
        title = stringResource(R.string.high_score),
        onBackClicked = { navController.popBackStack() }) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = contentPadding.calculateTopPadding(),
                    bottom = padding16dp,
                    start = padding16dp,
                    end = padding16dp
                )
                .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground),
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(padding16dp)
            ) {
                BodyLarge(
                    text = "#",
                    modifier = Modifier.weight(0.5f),
                    textAlign = TextAlign.Start
                )
                BodyLarge(
                    text = stringResource(R.string.player_name),
                    modifier = Modifier.weight(1f),
                    textAlign = TextAlign.Start
                )
                BodyLarge(
                    text = stringResource(R.string.score),
                    modifier = Modifier.weight(0.5f),
                    textAlign = TextAlign.End
                )
            }
            Divider()
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(highScores.size) { index ->
                    HighScoreItem(highScores[index], index)
                }
            }
        }
    }

}

@Composable
private fun HighScoreItem(highScore: HighScore, index: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(padding16dp)
    ) {
        BodyLarge(
            text = "#${index + 1}",
            modifier = Modifier.weight(0.5f),
            textAlign = TextAlign.Start
        )
        BodyLarge(
            text = highScore.playerName,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start
        )
        BodyLarge(
            text = highScore.score.toString(),
            modifier = Modifier.weight(0.5f),
            textAlign = TextAlign.End
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SnakeTheme {
        HighScoreScreen(rememberNavController())
    }
}
