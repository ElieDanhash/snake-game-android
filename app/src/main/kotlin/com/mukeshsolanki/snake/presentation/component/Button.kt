package com.mukeshsolanki.snake.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mukeshsolanki.snake.presentation.theme.*

@Composable
fun AppButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground
        ),
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.onBackground),
    ) {
        TitleLarge(
            modifier = Modifier.padding(padding8dp),
            text = text,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun AppIconButton(modifier: Modifier = Modifier, icon: ImageVector, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .border(1.dp, MaterialTheme.colorScheme.onBackground)
            .size(size64dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(corner4dp)
            ),
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview
@Composable
private fun Preview1() {
    SnakeTheme {
        AppButton(modifier = Modifier, text = "Test", onClick = {})
    }
}

@Preview
@Composable
private fun Preview2() {
    SnakeTheme {
        AppIconButton(modifier = Modifier, icon = Icons.Default.KeyboardArrowRight, onClick = {})
    }
}