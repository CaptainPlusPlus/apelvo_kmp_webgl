data class WebGLGameModel(
    val id: String,
    val name: String,
    val description: String,
    val htmlPath: String,
    val thumbnailPath: String
)

sealed interface GamePlayState {
    object Loading : GamePlayState
    object Playing : GamePlayState
    object Paused : GamePlayState
    data class Error(val message: String) : GamePlayState
} 