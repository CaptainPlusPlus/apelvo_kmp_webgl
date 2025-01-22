package nl.rayfox.multiplatform.navigation.demo.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import nl.rayfox.multiplatform.navigation.demo.ui.theme.PrimaryGreen
import androidx.compose.material.MaterialTheme

@Composable
fun ApelvoTopBar(
    onSettingsClick: () -> Unit
) {
    TopAppBar(
        backgroundColor = PrimaryGreen,
        elevation = 0.dp,
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Apelvo",
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White
                )
            }
        }
    )
} 