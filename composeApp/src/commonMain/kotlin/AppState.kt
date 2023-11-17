/*
 * Copyright 2023 OpenIndex.de.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
