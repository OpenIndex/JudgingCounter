import androidx.compose.runtime.Composable

enum class Orientation {
    PORTRAIT,
    LANDSCAPE,
}

interface Platform {
    val name: String
}

@Composable
expect fun getOrientation(): Orientation

expect fun getPlatform(): Platform
