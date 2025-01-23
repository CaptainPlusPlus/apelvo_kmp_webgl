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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.min
import nl.rayfox.multiplatform.navigation.demo.ui.theme.StatCardGreen
import nl.rayfox.multiplatform.navigation.demo.ui.theme.ProgressBackgroundGreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BarChart(
    values: List<Float>,
    modifier: Modifier = Modifier,
    maxHeight: Dp = 120.dp
) {
    Row(
        modifier = modifier
            .width(IntrinsicSize.Min)
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        values.forEach { value ->
            val barHeightFraction = value / (values.maxOrNull() ?: 1f)
            Box(
                modifier = Modifier
                    .width(16.dp)
                    .height(maxHeight)
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

@Preview
@Composable
private fun BarChartPreview() {
    MaterialTheme {
        BarChart(
            values = listOf(0.3f, 0.7f, 0.5f, 0.9f, 0.4f),
            maxHeight = 100.dp
        )
    }
}
