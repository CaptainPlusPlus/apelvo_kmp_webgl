package nl.rayfox.multiplatform.navigation.demo.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import nl.rayfox.multiplatform.navigation.demo.ui.components.ScreenLayout
import nl.rayfox.multiplatform.navigation.demo.ui.theme.DarkGreen
import nl.rayfox.multiplatform.navigation.demo.ui.theme.White

@Composable
fun TrainingScreen() {
    ScreenLayout {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Training Screen",
                    color = MaterialTheme.colors.onSurface
                )
            }
        }
    }