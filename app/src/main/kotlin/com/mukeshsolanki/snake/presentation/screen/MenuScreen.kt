package com.mukeshsolanki.snake.presentation.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mukeshsolanki.snake.R
import com.mukeshsolanki.snake.data.cache.GameCache
import com.mukeshsolanki.snake.domain.extension.launchActivity
import com.mukeshsolanki.snake.domain.navigation.Screen
import com.mukeshsolanki.snake.presentation.activity.GameActivity
import com.mukeshsolanki.snake.presentation.component.AppButton
import com.mukeshsolanki.snake.presentation.component.DisplayLarge
import com.mukeshsolanki.snake.presentation.component.IconTextButton
import com.mukeshsolanki.snake.presentation.theme.*
import kotlinx.coroutines.launch


@Composable
fun MenuScreen(navController: NavHostController) {
    val context = LocalContext.current
    val dataStore = GameCache(context.applicationContext)
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(width = border2dp, color = MaterialTheme.colorScheme.onBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val sound = dataStore.getSound.collectAsState(initial = true).value
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconTextButton(
                modifier = Modifier
                    .padding(padding8dp),
                drawable = R.drawable.ic_flag,
                text = R.string.high_score,
            ) {
                navController.navigate(Screen.HighScores.route)
            }
            IconTextButton(
                modifier = Modifier
                    .padding(padding8dp),
                text = R.string.sound,
                drawable = if (sound) R.drawable.ic_volume_up else R.drawable.ic_volume_off,
            ) {
                scope.launch {
                    dataStore.saveSound(!sound)
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding16dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            DisplayLarge(text = stringResource(R.string.app_name))
            AppButton(
                modifier = Modifier
                    .width(width248dp)
                    .padding(top = padding64dp),
                text = stringResource(R.string.new_game)
            ) { context.launchActivity<GameActivity>() }
            AppButton(
                modifier = Modifier
                    .width(width248dp)
                    .padding(top = padding16dp), text = stringResource(R.string.settings)
            ) {
                navController.navigate(Screen.Settings.route)
            }
            AppButton(
                modifier = Modifier
                    .width(width248dp)
                    .padding(top = padding16dp), text = stringResource(R.string.about)
            ) {
                navController.navigate(Screen.About.route)
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SnakeTheme {
        MenuScreen(rememberNavController())
    }

}