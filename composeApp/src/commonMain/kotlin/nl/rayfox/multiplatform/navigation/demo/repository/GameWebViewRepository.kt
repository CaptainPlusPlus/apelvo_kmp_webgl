class GameWebViewRepository {
    private val availableGames = listOf(
        WebGLGameModel(
            id = "game1",
            name = "Sample Game",
            description = "A WebGL sample game",
            htmlPath = "games/sample-game/index.html",
            thumbnailPath = "games/sample-game/thumbnail.png"
        )
    )

    fun getAvailableGames(): List<WebGLGameModel> = availableGames

    fun getGameById(id: String): WebGLGameModel? = 
        availableGames.find { it.id == id }

    suspend fun loadGameHtml(gameId: String): Result<String> {
        return try {
            // Load HTML content from resources
            val html = readGameHtmlFromResources(gameId)
            Result.success(html)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private suspend fun readGameHtmlFromResources(gameId: String): String {
        // Implementation to read HTML from resources
        // This will depend on your resource management strategy
        return "" // Placeholder
    }
} 