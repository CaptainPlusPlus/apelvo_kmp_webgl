import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.IntSize
import kotlinx.browser.document
import org.w3c.dom.HTMLIFrameElement

@Composable
actual fun CrossPlatformWebView(
    url: String,
    modifier: Modifier
) {
    var iframeSize by remember { mutableStateOf(IntSize.Zero) }
    val iframeId = remember { "iframe-${kotlin.random.Random.nextInt()}" }

    Layout(
        content = {},
        modifier = modifier
    ) { _, constraints ->
        iframeSize = IntSize(constraints.maxWidth, constraints.maxHeight)
        layout(constraints.maxWidth, constraints.maxHeight) {}
    }

    DisposableEffect(url, iframeSize) {
        val iframe = document.getElementById(iframeId) as? HTMLIFrameElement ?: run {
            val newIframe = document.createElement("iframe") as HTMLIFrameElement
            newIframe.id = iframeId
            document.body?.appendChild(newIframe)
            newIframe
        }

        iframe.src = url
        iframe.style.apply {
            position = "absolute"
            top = "0"
            left = "0"
            width = "${iframeSize.width}px"
            height = "${iframeSize.height}px"
            border = "none"
            zIndex = "1"
        }

        onDispose {
            document.getElementById(iframeId)?.remove()
        }
    }
}