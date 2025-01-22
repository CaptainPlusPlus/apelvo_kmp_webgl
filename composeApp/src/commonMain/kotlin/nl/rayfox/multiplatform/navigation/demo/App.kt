import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import nl.rayfox.multiplatform.navigation.demo.navigation.Screen
import nl.rayfox.multiplatform.navigation.demo.ui.components.ApelvoBottomBar
import nl.rayfox.multiplatform.navigation.demo.ui.components.ApelvoTopBar
import nl.rayfox.multiplatform.navigation.demo.ui.animation.springInFromBottom
import nl.rayfox.multiplatform.navigation.demo.ui.animation.springOutToBottom
import nl.rayfox.multiplatform.navigation.demo.ui.screen.*
import nl.rayfox.multiplatform.navigation.demo.ui.theme.ApelvoTheme
import nl.rayfox.multiplatform.navigation.demo.ui.theme.DarkGreen
import nl.rayfox.multiplatform.navigation.demo.ui.theme.PrimaryGreen

@Composable
fun App() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    ApelvoTheme {
        Scaffold(
            backgroundColor = PrimaryGreen,
            topBar = {
                ApelvoTopBar(
                    onSettingsClick = {
                        navController.navigate(Screen.Settings.route)
                    }
                )
            },
            bottomBar = {
                ApelvoBottomBar(
                    currentRoute = currentRoute,
                    onNavigate = { screen ->
                        navController.navigate(screen.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            popUpTo(Screen.Overview.route) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
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
                        route = Screen.Progress.route,
                        enterTransition = { springInFromBottom() },
                        exitTransition = { springOutToBottom() }
                    ) {
                        ProgressScreen()
                    }
                    composable(
                        route = Screen.Settings.route,
                        enterTransition = { springInFromBottom() },
                        exitTransition = { springOutToBottom() }
                    ) {
                        SettingsScreen()
                    }
                }
            }
        }
    }
}