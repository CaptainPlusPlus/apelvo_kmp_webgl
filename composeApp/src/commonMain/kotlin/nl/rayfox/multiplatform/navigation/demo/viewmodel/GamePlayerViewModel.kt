import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import nl.rayfox.multiplatform.navigation.demo.getPlatform

class GamePlayerViewModel(
    private val gameRepository: GameWebViewRepository
) : ViewModel() {
    private val _gameState = MutableStateFlow<GamePlayState>(GamePlayState.Loading)
    val gameState: StateFlow<GamePlayState> = _gameState

//    private val _webViewState = MutableStateFlow<WebViewState?>(null)
//    val webViewState: StateFlow<WebViewState?> = _webViewState

    fun loadGame(gameId: String) {
        viewModelScope.launch {
            _gameState.value = GamePlayState.Loading
            // Temporary until WebView is fully implemented
            val game = gameRepository.getGameById(gameId)
            if (game != null) {
                _gameState.value = GamePlayState.Playing
            } else {
                _gameState.value = GamePlayState.Error("Game not found")
            }
        }
    }
}