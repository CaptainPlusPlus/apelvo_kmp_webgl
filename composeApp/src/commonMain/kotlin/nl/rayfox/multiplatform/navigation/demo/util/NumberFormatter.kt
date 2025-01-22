package nl.rayfox.multiplatform.navigation.demo.util

import kotlin.math.roundToInt

object NumberFormatter {
    fun Float.roundToDecimals(decimals: Int): Float {
        var dotAt = 1
        repeat(decimals) { dotAt *= 10 }
        val roundedValue = (this * dotAt).roundToInt()
        return (roundedValue / dotAt) + (roundedValue % dotAt).toFloat() / dotAt
    }
} 