package nl.rayfox.multiplatform.navigation.demo.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import nl.rayfox.multiplatform.navigation.demo.ui.components.ScreenLayout

@Composable
fun SettingsScreen(
    onNavigateToSubsetting: (String) -> Unit = {}
) {
    ScreenLayout {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Settings Screen")
                // Example of nested navigation
                // Button(onClick = { onNavigateToSubsetting("profile") }) {
                //     Text("Go to Profile Settings")
                // }
            }
        }
    }
} 