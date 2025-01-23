import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameHubViewModel(
    private val gameRepository: GameWebViewRepository
) : ViewModel() {
    private val _games = MutableStateFlow<List<WebGLGameModel>>(emptyList())
    val games: StateFlow<List<WebGLGameModel>> = _games

    init {
        loadGames()
    }

    private fun loadGames() {
        _games.value = gameRepository.getAvailableGames()
    }

    fun onGameSelected(gameId: String) {
        // Navigate to game screen
        // This will be handled by your navigation system
    }
}