@Composable
actual fun CrossPlatformWebView(
    url: String,
    modifier: Modifier
) {
    val state = rememberWebViewState(url)
    val navigator = rememberWebViewNavigator()
    
    WebView(
        state = state,
        modifier = modifier,
        navigator = navigator
    )
} 