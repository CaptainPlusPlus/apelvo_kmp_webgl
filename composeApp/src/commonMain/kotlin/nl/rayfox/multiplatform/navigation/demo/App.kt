import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import nl.rayfox.multiplatform.navigation.demo.ui.components.ApelvoBottomBar
import nl.rayfox.multiplatform.navigation.demo.ui.components.ApelvoTopBar
import nl.rayfox.multiplatform.navigation.demo.ui.animation.springInFromBottom
import nl.rayfox.multiplatform.navigation.demo.ui.animation.springOutToBottom
import nl.rayfox.multiplatform.navigation.demo.ui.navigation.Screen
import nl.rayfox.multiplatform.navigation.demo.ui.screen.*
import nl.rayfox.multiplatform.navigation.demo.ui.theme.ApelvoTheme
import nl.rayfox.multiplatform.navigation.demo.ui.theme.DarkGreen
import nl.rayfox.multiplatform.navigation.demo.ui.theme.PrimaryGreen

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    // Track if we're in settings flow
    val isInSettingsFlow = currentRoute?.startsWith(Screen.Settings.route) ?: false

    ApelvoTheme {
        Scaffold(
            backgroundColor = PrimaryGreen,
            topBar = {
                ApelvoTopBar(
                    onSettingsClick = {
                        if (isInSettingsFlow) {
                            // Just pop back to the previous screen instead of forcing Overview
                            navController.popBackStack()
                        } else {
                            navController.navigate(Screen.Settings.route) {
                                // Preserve the back stack when entering settings
                                launchSingleTop = true
                            }
                        }
                    },
                    isInSettingsFlow = isInSettingsFlow
                )
            },
            bottomBar = {
                // Hide bottom bar in settings flow
                if (!isInSettingsFlow) {
                    ApelvoBottomBar(
                        currentRoute = currentRoute,
                        onNavigate = { screen ->
                            navController.navigate(screen.route) {
                                popUpTo(Screen.Overview.route) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier.padding(paddingValues)
            ) {
                NavHost(
                    navController = navController,
                    startDestination = Screen.Overview.route,
                ) {
                    composable(
                        route = Screen.Overview.route,
                        enterTransition = { springInFromBottom() },
                        exitTransition = { springOutToBottom() }
                    ) {
                        MainMenuScreen()
                    }
                    composable(
                        route = Screen.Training.route,
                        enterTransition = { springInFromBottom() },
                        exitTransition = { springOutToBottom() }
                    ) {
                        TrainingScreen()
                    }
                    composable(
                        route = Screen.GameHub.route,
                        enterTransition = { springInFromBottom() },
                        exitTransition = { springOutToBottom() }
                    ) {
                        GameHubScreen(
                            onGameSelected = { gameId ->
                                navController.navigate("game/$gameId")
                            }
                        )
                    }
                    composable(
                        route = Screen.Settings.route,
                        enterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> fullWidth }
                            ) + fadeIn()
                        },
                        exitTransition = {
                            slideOutHorizontally(
                                targetOffsetX = { fullWidth -> fullWidth }
                            ) + fadeOut()
                        }
                    ) {
                        SettingsScreen(
                            onNavigateToSubsetting = { subsettingRoute ->
                                navController.navigate("settings/$subsettingRoute")
                            }
                        )
                    }
                    composable(
                        route = "game/{gameId}",
                        arguments = listOf(navArgument("gameId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val gameId = backStackEntry.arguments?.getString("gameId") ?: return@composable
                        GameWebViewScreen(gameId = gameId)
                    }
                    // Example of nested settings route
                    composable(
                        route = "settings/{subsetting}",
                        arguments = listOf(navArgument("subsetting") { type = NavType.StringType }),
                        enterTransition = {
                            slideInHorizontally(
                                initialOffsetX = { fullWidth -> fullWidth }
                            ) + fadeIn()
                        },
                        exitTransition = {
                            slideOutHorizontally(
                                targetOffsetX = { fullWidth -> fullWidth }
                            ) + fadeOut()
                        }
                    ) { backStackEntry ->
                        val subsetting = backStackEntry.arguments?.getString("subsetting")
                        // Handle subsetting screens
                    }
                }
            }
        }
    }
}