package nl.rayfox.multiplatform.navigation.demo.ui.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BarChart(values: List<Float>, modifier: Modifier = Modifier) {
    val maxVal = values.maxOrNull() ?: 1f

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        values.forEach { value ->
            val barHeightFraction = value / maxVal
            Box(
                modifier = Modifier
                    .width(20.dp)
                    .height(100.dp)  // total height
                    .clip(RoundedCornerShape(4.dp)) // slightly rounded top corners
                    .background(Color.LightGray),
                contentAlignment = Alignment.BottomCenter
            ) {
                // The "fill" part
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(barHeightFraction)
                        .background(Color.Green)
                )
            }
        }
    }
}
