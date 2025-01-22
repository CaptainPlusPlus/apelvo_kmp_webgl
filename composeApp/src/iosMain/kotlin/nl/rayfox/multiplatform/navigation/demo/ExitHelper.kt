package com.multiplatform.app

import platform.Foundation.NSThread
import platform.UIKit.UIApplication

actual class ExitHelper {
    actual fun exitApp() {
        // On iOS, we can't really "exit" the app, but we can:
        // 1. Either suspend it
        UIApplication.sharedApplication.suspend()
        // 2. Or force exit (not recommended for App Store)
        // NSThread.exit()
    }
} 