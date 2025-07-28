package eu.codlab.files

import kotlinx.browser.localStorage

actual suspend fun touch(path: String) {
    if (null != localStorage.getItem(path)) return

    localStorage.setItem(path, "")
}
