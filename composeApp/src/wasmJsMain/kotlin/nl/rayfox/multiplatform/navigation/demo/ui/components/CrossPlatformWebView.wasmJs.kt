import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import org.w3c.dom.HTMLIFrameElement
import kotlinx.browser.document
//import org.jetbrains.compose.web.dom.Iframe
//import org.jetbrains.compose.web.css.*

@Composable
actual fun CrossPlatformWebView(
    url: String,
    modifier: Modifier
) {
    val iframeId = remember { "iframe-${kotlin.random.Random.nextInt()}" }

    DisposableEffect(url) {
        val iframe = document.createElement("iframe") as HTMLIFrameElement
        iframe.id = iframeId
        iframe.src = url
        iframe.style.apply {
            width = "100%"
            height = "100%"
            border = "none"
        }

        document.body?.appendChild(iframe)

        onDispose {
            document.getElementById(iframeId)?.remove()
        }
    }
}