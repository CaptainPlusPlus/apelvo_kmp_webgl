package nl.rayfox.multiplatform.navigation.demo.ui.cards

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nl.rayfox.multiplatform.navigation.demo.ui.theme.PrimaryGreen
import nl.rayfox.multiplatform.navigation.demo.ui.theme.StatCardGreen
import nl.rayfox.multiplatform.navigation.demo.ui.theme.ProgressBackgroundGreen

@Composable
fun CircularProgressIndicator(
    progress: Float,            // 0.0 to 1.0
    displayedPercentage: Float, // for textual display, e.g. 48.2
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(140.dp)
    ) {
        Canvas(modifier = Modifier.size(140.dp)) {
            val strokeWidth = 12.dp.toPx()
            // Background circle
            drawArc(
                color = ProgressBackgroundGreen,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth,
                    cap = StrokeCap.Round
                )
            )
            // Progress arc
            drawArc(
                color = PrimaryGreen,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(
                    width = strokeWidth,
                    cap = StrokeCap.Round
                )
            )
        }
        Text(
            text = "${displayedPercentage.toInt()}%",
            style = MaterialTheme.typography.h6.copy(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black
        )
    }
}
