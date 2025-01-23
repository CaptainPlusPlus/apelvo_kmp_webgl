package nl.rayfox.multiplatform.navigation.demo.ui.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import nl.rayfox.multiplatform.navigation.demo.ui.theme.StatCardGreen
import nl.rayfox.multiplatform.navigation.demo.ui.theme.ProgressBackgroundGreen

@Composable
fun BarChart(values: List<Float>, modifier: Modifier = Modifier) {
    val maxVal = values.maxOrNull() ?: 1f

    Row(
        modifier = modifier
            .width(IntrinsicSize.Min)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp) // 8dp spacing between bars
    ) {
        values.forEach { value ->
            val barHeightFraction = value / maxVal
            Box(
                modifier = Modifier
                    .width(24.dp)
                    .height(120.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(ProgressBackgroundGreen),
                contentAlignment = Alignment.BottomCenter
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(barHeightFraction)
                        .clip(RoundedCornerShape(8.dp))
                        .background(StatCardGreen)
                )
            }
        }
    }
}
