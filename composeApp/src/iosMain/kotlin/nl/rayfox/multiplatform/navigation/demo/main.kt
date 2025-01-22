import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.multiplatform.app.ExitHelper

fun MainViewController() {
    val lifecycle = LifecycleRegistry()
    val rootComponent = RootComponent(
        componentContext = DefaultComponentContext(lifecycle),
        exitHelper = ExitHelper()
    )
    
    ComposeView {
        App(rootComponent)
    }
} 