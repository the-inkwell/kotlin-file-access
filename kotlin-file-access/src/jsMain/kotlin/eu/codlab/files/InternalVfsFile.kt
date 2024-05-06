package eu.codlab.files

import korlibs.io.file.VfsFile

internal actual class InternalVfsFile actual constructor(val vfsFile: VfsFile) {
    actual suspend fun exists(): Boolean {
        return false
    }

    actual suspend fun readString(): String {
        throw NullPointerException("can't read string on this platform")
    }

    actual suspend fun read(): ByteArray {
        throw NullPointerException("can't read string on this platform")
    }

    actual suspend fun write(byteArray: ByteArray): Long {
        return 0
    }

    actual suspend fun mkdir(): Boolean {
        return false
    }

    actual suspend fun mkdirs(): Boolean {
        return false
    }

    actual suspend fun touch(): Boolean {
        return false
    }

    actual suspend fun delete(): Boolean {
        return false
    }
}
