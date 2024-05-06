package eu.codlab.files

import platform.Foundation.NSFileManager

actual suspend fun touch(path: String) {
    NSFileManager.defaultManager.createFileAtPath(path, null, null)
}
