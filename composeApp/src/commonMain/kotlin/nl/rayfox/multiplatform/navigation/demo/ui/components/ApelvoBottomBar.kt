package nl.rayfox.multiplatform.navigation.demo.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import nl.rayfox.multiplatform.navigation.demo.ui.navigation.Screen

data class BottomNavItem(
    val screen: Screen,
    val icon: ImageVector,
    val label: String
)

@Composable
fun ApelvoBottomBar(
    currentRoute: String?,
    onNavigate: (Screen) -> Unit
) {
    val items = listOf(
        BottomNavItem(Screen.Overview, Icons.Default.Home, "Overview"),
        BottomNavItem(Screen.Training, Icons.Default.Person, "Training"),
        BottomNavItem(Screen.Progress, Icons.Default.PlayArrow, "Games"),
    )

    BottomNavigation {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.screen.route,
                onClick = { onNavigate(item.screen) }
            )
        }
    }
}