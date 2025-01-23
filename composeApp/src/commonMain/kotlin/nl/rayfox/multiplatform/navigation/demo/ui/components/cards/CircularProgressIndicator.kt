package nl.rayfox.multiplatform.navigation.demo.ui.cards

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.Dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CircularProgressIndicator(
    progress: Float,            // 0.0 to 1.0
    displayedPercentage: Float, // for textual display, e.g. 48.2
    modifier: Modifier = Modifier,
    size: Dp = 140.dp
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(size)
    ) {
        Canvas(modifier = Modifier.size(size)) {
            val strokeWidth = (size * 0.085f).toPx()
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
                fontSize = (size * 0.17f).value.sp,
                fontWeight = FontWeight.Bold
            ),
            color = Color.Black
        )
    }
}

@Preview
@Composable
private fun CircularProgressIndicatorPreview() {
    MaterialTheme {
        Column {
            CircularProgressIndicator(
                progress = 0.75f,
                displayedPercentage = 75f
            )
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator(
                progress = 0.48f,
                displayedPercentage = 48f,
                size = 100.dp
            )
        }
    }
}
