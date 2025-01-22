package nl.rayfox.multiplatform.navigation.demo.util

import kotlin.math.roundToInt

object NumberFormatter {
    fun Float.roundToDecimals(decimals: Int): Float {
        var multiplier = 1f
        repeat(decimals) { multiplier *= 10f }
        return (this * multiplier).roundToInt() / multiplier
    }
} 