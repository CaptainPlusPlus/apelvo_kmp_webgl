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

// If using string composeResources for localization, you’d do:
// import androidx.compose.ui.res.stringResource
// import nl.rayfox.multiplatform.navigation.demo.R // For Android

@Composable
fun MainMenuScreen (
    // For a real app you'd inject or retrieve via DI (e.g., hiltViewModel)
    viewModel: MainMenuViewModel = MainMenuViewModel()
) {
    // Example: if you want to store the VM in local state:
    // val vm = remember { OverviewViewModel() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1) Top Image (banner or header background)
        // For multiplatform:
        //  - Android: painterResource(R.drawable.my_top_image)
        //  - Desktop: painterResource("images/my_top_image.png")
        Image(
            painter = painterResource(Res.drawable.apelvo_logo), // Replace with your resource name
            contentDescription = "Header Image",       // stringResource(R.string.header_image_desc)
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)  // Adjust as needed
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2) "Hallo Leo!" -- ignoring the small icon
        Text(
            text = /* stringResource(R.string.hallo_name) */ "Hallo Leo!",
            // You can choose a heading style from your ApelvoTheme or define your own.
            // For example, if your theme's typography is not set, you could do:
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 3) "Übersicht" and subhead
        Text(
            text = /* stringResource(R.string.overview_title) */ "Übersicht",
            fontSize = 20.sp,
            fontFamily = FontFamily.SansSerif
        )
        Text(
            text = /* stringResource(R.string.check_training_progress) */ "Schau dir deinen Trainingsfortschritt an!",
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 4) Row for "1466 Gesamtpunkte" and "1,57 Spielstunden"
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Left card
            OverviewStatCard(
                title = /* stringResource(R.string.total_points) */ "Gesamtpunkte",
                value = viewModel.totalPoints.toString()
            )

            // Right card
            OverviewStatCard(
                title = /* stringResource(R.string.play_hours) */ "Spielstunden",
                value = viewModel.totalPlayHours.toString()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 5) Circular progress
        CircularProgressIndicator(
            progress = viewModel.circularProgress / 100f,
            displayedPercentage = viewModel.circularProgress
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 6) Simple Bar Chart
        Text(
            text = "Mo 01.07 - Fr 05.07", // for example
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif
        )
        BarChart(values = viewModel.barChartValues)
    }
}
