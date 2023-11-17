import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

@Composable
@OptIn(ExperimentalComposeUiApi::class)
actual fun getOrientation(): Orientation {
    val size = LocalWindowInfo.current.containerSize
    return if (size.width > size.height)
        Orientation.LANDSCAPE
    else
        Orientation.PORTRAIT
}

actual fun getPlatform(): Platform = IOSPlatform()