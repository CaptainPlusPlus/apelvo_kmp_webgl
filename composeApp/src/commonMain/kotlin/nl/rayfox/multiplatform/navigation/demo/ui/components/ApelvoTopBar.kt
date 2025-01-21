package nl.rayfox.multiplatform.navigation.demo.ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import nl.rayfox.multiplatform.navigation.demo.ui.theme.PrimaryGreen

@Composable
fun ApelvoTopBar(
    onSettingsClick: () -> Unit
) {
    TopAppBar(
        title = { Text("Apelvo") },
        backgroundColor = PrimaryGreen,
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings"
                )
            }
        }
    )
} 