package com.nuniwa.androidlib

import com.nuniwa.corelib.Circle
import com.nuniwa.corelib.Rectangle

interface ShapesManager {
    fun calculatePerimeter(rectangle: Rectangle)

    fun calculateLength(circle: Circle)
}
