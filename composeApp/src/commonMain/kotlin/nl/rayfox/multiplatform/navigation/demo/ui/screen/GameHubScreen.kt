package nl.rayfox.multiplatform.navigation.demo.ui.screen

import GameHubViewModel
import GameWebViewRepository
import WebGLGameModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import nl.rayfox.multiplatform.navigation.demo.ui.components.ScreenLayout
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun GameHubScreen(
    onGameSelected: (String) -> Unit,
    viewModel: GameHubViewModel = viewModel { GameHubViewModel(GameWebViewRepository()) }
) {
    val games by viewModel.games.collectAsState()

    ScreenLayout {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(games) { game ->
                GameCard(
                    game = game,
                    onGameSelected = onGameSelected
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun GameCard(
    game: WebGLGameModel,
    onGameSelected: (String) -> Unit
) {
    Card(
        onClick = { onGameSelected(game.id) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = game.name,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = game.description,
                style = MaterialTheme.typography.body2
            )
        }
    }
}
