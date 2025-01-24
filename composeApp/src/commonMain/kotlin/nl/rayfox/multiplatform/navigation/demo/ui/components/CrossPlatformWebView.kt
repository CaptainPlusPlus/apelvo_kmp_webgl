import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun CrossPlatformWebView(
    url: String,
    modifier: Modifier = Modifier
)