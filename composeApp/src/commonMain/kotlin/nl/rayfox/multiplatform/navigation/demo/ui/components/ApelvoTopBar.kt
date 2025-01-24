package nl.rayfox.multiplatform.navigation.demo.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import nl.rayfox.multiplatform.navigation.demo.ui.theme.PrimaryGreen
import androidx.compose.material.MaterialTheme
import navigationthemedemo.composeapp.generated.resources.Res
import navigationthemedemo.composeapp.generated.resources.apelvo_logo
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ApelvoTopBar(
    onSettingsClick: () -> Unit,
    isInSettingsFlow: Boolean = false
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(PrimaryGreen)
    ) {
        // Centered Logo
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.apelvo_logo),
                contentDescription = "Apelvo Logo",
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(0.4f), // Adjust this value to control logo width
                contentScale = ContentScale.Fit
            )
        }

        // Settings Icon (positioned absolutely)
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
        ) {
            IconButton(onClick = onSettingsClick) {
                AnimatedContent(
                    targetState = isInSettingsFlow,
                    transitionSpec = {
                        fadeIn() togetherWith fadeOut()
                    }
                ) { inSettings ->
                    Icon(
                        imageVector = if (inSettings) Icons.Default.Close else Icons.Default.Settings,
                        contentDescription = if (inSettings) "Close Settings" else "Open Settings",
                        tint = Color.White
                    )
                }
            }
        }
    }
} 