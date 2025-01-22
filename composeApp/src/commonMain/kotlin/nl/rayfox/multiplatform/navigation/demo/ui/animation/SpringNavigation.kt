package nl.rayfox.multiplatform.navigation.demo.ui.animation

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.AnimatedContentTransitionScope

fun springInFromBottom(): EnterTransition {
    return slideInVertically(
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMediumLow
        ),
        initialOffsetY = { fullHeight -> fullHeight }
    )
}

fun springOutToBottom(): ExitTransition {
    return slideOutVertically(
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMediumLow
        ),
        targetOffsetY = { fullHeight -> fullHeight }
    )
} 