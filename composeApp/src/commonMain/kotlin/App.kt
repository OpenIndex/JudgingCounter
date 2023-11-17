import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun App() {
    MaterialTheme {
        val state = remember { AppState() }
        val orientation by mutableStateOf(getOrientation())

        when (orientation) {
            Orientation.PORTRAIT -> PortraitView(state)
            Orientation.LANDSCAPE -> LandscapeView(state)
        }

        AnimatedVisibility(
            visible = state.started,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
            ) {
                IconButton(
                    onClick = { state.reset() },
                    modifier = Modifier
                        .align(Alignment.Center)
                        .scale(3f),
                ) {
                    Icon(
                        imageVector = Icons.Sharp.Refresh,
                        contentDescription = "reset",
                        tint = Color.White,
                        modifier = Modifier
                            .scale(scaleX = -1f, scaleY = 1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun LandscapeView(
    state: AppState,
) {
    Row(
        //horizontalArrangement = Arrangement.spacedBy(1.dp),
        modifier = Modifier
            .fillMaxSize(),
    ) {

        CountButton(
            text = state.redCounter,
            color = Color.Red,
            onClick = { state.increaseRed() },
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)
        )

        CountButton(
            text = state.blueCounter,
            color = Color.Blue,
            onClick = { state.increaseBlue() },
            modifier = Modifier
                .fillMaxHeight()
                .weight(0.5f)
        )
    }
}

@Composable
private fun PortraitView(
    state: AppState,
) {
    Column(
        //verticalArrangement = Arrangement.spacedBy(1.dp),
        modifier = Modifier
            .fillMaxSize(),
    ) {

        CountButton(
            text = state.redCounter,
            color = Color.Red,
            onClick = { state.increaseRed() },
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        )

        CountButton(
            text = state.blueCounter,
            color = Color.Blue,
            onClick = { state.increaseBlue() },
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
        )
    }
}

@Composable
private fun CountButton(
    text: String,
    color: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        onClick = onClick,
        shape = RectangleShape,
        border = BorderStroke(0.dp, color),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color,
            contentColor = Color.White,
        ),
        modifier = modifier,
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h1,
            fontWeight = FontWeight.Bold,
        )
    }
}
