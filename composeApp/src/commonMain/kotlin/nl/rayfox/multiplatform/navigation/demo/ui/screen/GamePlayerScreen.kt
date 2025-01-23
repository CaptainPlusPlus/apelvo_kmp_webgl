import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import nl.rayfox.multiplatform.navigation.demo.ui.components.ScreenLayout

@Composable
fun GamePlayerScreen(
    gameId: String,
    viewModel: GamePlayerViewModel = viewModel { GamePlayerViewModel(GameWebViewRepository()) }
) {
    val gameState by viewModel.gameState.collectAsState()

    LaunchedEffect(gameId) {
        viewModel.loadGame(gameId)
    }

    ScreenLayout {
        Box(modifier = Modifier.fillMaxSize()) {
            when (gameState) {
                is GamePlayState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                is GamePlayState.Playing -> {
                    Text("Game is playing", modifier = Modifier.align(Alignment.Center))
                }
                is GamePlayState.Error -> {
                    Text(
                        text = (gameState as GamePlayState.Error).message,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> Unit
            }
        }
    }
}