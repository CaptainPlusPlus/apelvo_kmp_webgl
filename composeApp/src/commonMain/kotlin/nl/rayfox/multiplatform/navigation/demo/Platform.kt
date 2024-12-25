package nl.rayfox.multiplatform.navigation.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform