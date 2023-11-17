import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class AppState {
    private var red by mutableStateOf(0)
    private var blue by mutableStateOf(0)

    val redCounter: String
        get() = red.toString()

    val blueCounter: String
        get() = blue.toString()

    val started: Boolean
        get() = red > 0 || blue > 0

    fun increaseRed() {
        red += 1
    }

    fun increaseBlue() {
        blue += 1
    }

    fun reset() {
        red = 0
        blue = 0
    }
}
