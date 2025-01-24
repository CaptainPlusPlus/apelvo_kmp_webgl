import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.multiplatform.webview.web.WebView
import com.multiplatform.webview.web.rememberWebViewNavigator
import com.multiplatform.webview.web.rememberWebViewState

@Composable
actual fun CrossPlatformWebView(url: String, modifier: Modifier) {
    val state = rememberWebViewState(url)
    val navigator = rememberWebViewNavigator()

    WebView(
        state = state,
        modifier = modifier,
        navigator = navigator
    )
}