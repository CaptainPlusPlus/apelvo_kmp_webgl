package nl.rayfox.multiplatform.navigation.demo.ui.screen

import kotlin.random.Random
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class MainMenuViewModel {
    var totalPoints by mutableStateOf(1466)       // Just an example
    var totalPlayHours by mutableStateOf(1.57f)   // Just an example
    var circularProgress by mutableStateOf(48.2f) // For demonstration

    // Example bar chart data: 5 entries (Mon-Fri) in range 0..100
    var barChartValues = List(5) { Random.nextInt(0, 101).toFloat() }
}
