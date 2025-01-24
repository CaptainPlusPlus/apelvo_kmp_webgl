import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GameWebViewScreen(
    gameId: String,
    viewModel: GamePlayerViewModel = viewModel { GamePlayerViewModel(GameWebViewRepository()) }
) {
    val game = remember { viewModel.loadGame(gameId) }

    Box(modifier = Modifier.fillMaxSize()) {
        CrossPlatformWebView(
            url = "https://www.funkykarts.rocks/demo.html",
            modifier = Modifier.fillMaxSize()
        )
    }
}