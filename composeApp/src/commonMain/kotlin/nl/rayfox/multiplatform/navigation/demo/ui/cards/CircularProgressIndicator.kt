package nl.rayfox.multiplatform.navigation.demo.ui.cards

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressIndicator(
    progress: Float,            // 0.0 to 1.0
    displayedPercentage: Float, // for textual display, e.g. 48.2
    modifier: Modifier = Modifier
) {
    // Just a basic example
    Box(contentAlignment = Alignment.Center) {
        Canvas(modifier = modifier.size(100.dp)) {
            val strokeWidth = 8.dp.toPx()
            drawArc(
                color = Color.LightGray,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
            drawArc(
                color = Color.Green,
                startAngle = -90f,
                sweepAngle = 360 * progress,
                useCenter = false,
                style = Stroke(width = strokeWidth, cap = StrokeCap.Round)
            )
        }
        Text(text = displayedPercentage.toString(),
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif)
    }
}
