package nl.rayfox.multiplatform.navigation.demo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import navigationthemedemo.composeapp.generated.resources.Res
import navigationthemedemo.composeapp.generated.resources.apelvo_logo
import nl.rayfox.multiplatform.navigation.demo.ui.cards.BarChart
import nl.rayfox.multiplatform.navigation.demo.ui.cards.CircularProgressIndicator
import nl.rayfox.multiplatform.navigation.demo.ui.cards.OverviewStatCard
import org.jetbrains.compose.resources.painterResource
import nl.rayfox.multiplatform.navigation.demo.ui.components.ScreenLayout
import androidx.compose.material.MaterialTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

// If using string composeResources for localization, you'd do:
// import androidx.compose.ui.res.stringResource
// import nl.rayfox.multiplatform.navigation.demo.R // For Android

@Composable
fun MainMenuScreen(
    viewModel: MainMenuViewModel = MainMenuViewModel()
) {
    ScreenLayout {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val screenHeight = maxHeight
            
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                // Stats Cards Section
                Row(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    OverviewStatCard(
                        title = "Gesamtpunkte",
                        value = viewModel.totalPoints.toString(),
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    OverviewStatCard(
                        title = "Spielstunden",
                        value = "27.3",
                        modifier = Modifier.weight(1f)
                    )
                }

                // Circular Progress Section
                CircularProgressIndicator(
                    progress = viewModel.circularProgress / 100f,
                    displayedPercentage = viewModel.circularProgress,
                    size = (screenHeight * 0.25f).coerceAtMost(160.dp)
                )

                // Bar Chart Section
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(vertical = 8.dp)
                ) {
                    Text(
                        text = "Mo 01.07 - Fr 05.07",
                        fontSize = 14.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    BarChart(
                        values = viewModel.barChartValues,
                        maxHeight = (screenHeight * 0.2f).coerceAtMost(140.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun MainMenuScreenPreview() {
    MaterialTheme {
        MainMenuScreen()
    }
}
