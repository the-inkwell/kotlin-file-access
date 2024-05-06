package eu.codlab.files

import android.annotation.SuppressLint
import android.content.Context

internal var AndroidRootPath: String = ""

@SuppressLint("StaticFieldLeak")
var AndroidContext: Context? = null
    internal set


actual val RootPath: String
    get() = AndroidRootPath
