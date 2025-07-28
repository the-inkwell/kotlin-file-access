package eu.codlab.files

import korlibs.crypto.encoding.fromBase64
import korlibs.crypto.encoding.toBase64
import korlibs.io.file.VfsFile
import kotlinx.browser.localStorage

actual typealias VfsFileAccess = String

internal actual fun VirtualFile.getAccessor(vfs: VfsFile) = absolutePath

/**
 * The Javascript implementation is unoptimal for now
 * as writing and reading passthrough b64 encoding/decoding...
 *
 * Looking for a better alternative like the local db instead of localstorage
 * but this will come at a later time
 */
internal actual class InternalVfsFile actual constructor(
    private val accessor: VfsFileAccess
) {
    actual suspend fun exists(): Boolean {
        return localStorage.getItem(accessor) != null
    }

    actual suspend fun readString(): String {
        if (!exists()) throw IllegalStateException("File not found")

        return read().decodeToString()
    }

    actual suspend fun read(): ByteArray {
        return (localStorage.getItem(accessor) ?: "").fromBase64()
    }

    actual suspend fun write(byteArray: ByteArray): Long {
        return byteArray.toBase64().let {
            localStorage.setItem(accessor, it)
            it.length.toLong()
        }
    }

    actual suspend fun mkdir(): Boolean {
        // TODO check that the content was empty ?

        return touch()
    }

    actual suspend fun mkdirs(): Boolean {
        // TODO check that the content was empty ?

        return touch()
    }

    actual suspend fun touch(): Boolean {
        if (null != localStorage.getItem(accessor)) return true

        localStorage.setItem(accessor, "")
        return true
    }

    actual suspend fun delete(): Boolean {
        if (!exists()) return false

        localStorage.removeItem(accessor)
        return true
    }
}
