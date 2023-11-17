import android.content.res.Configuration
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

@Composable
actual fun getOrientation(): Orientation {
    return if (LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE)
        Orientation.LANDSCAPE
    else
        Orientation.PORTRAIT
}

actual fun getPlatform(): Platform = AndroidPlatform()
