package com.nuniwa.commonlib

import android.content.Context

actual class TestClass(context: Context) {
    fun acceptContext(context: Context) = Unit
}
