package nl.rayfox.multiplatform.navigation.demo.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
inline fun <reified VM : Any> rememberViewModel(
    crossinline viewModelCreator: () -> VM
): VM = remember { viewModelCreator() } 