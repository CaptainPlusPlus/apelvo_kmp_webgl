package nl.rayfox.multiplatform.navigation.demo.ui.navigation

sealed class Screen(val route: String) {
    data object Overview : Screen("overview")
    data object Training : Screen("training")
    data object Progress : Screen("progress")
    data object Settings : Screen("settings")
    data object GameList : Screen("games")
    data object Bluetooth : Screen("bluetooth")

    // For game details with parameter
    data object GameDetail : Screen("game/{gameId}") {
        fun createRoute(gameId: String) = "game/$gameId"
    }
}