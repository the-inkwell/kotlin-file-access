package eu.codlab.files

import korlibs.io.file.VfsFile
import korlibs.time.DateTime

internal actual typealias VfsFileAccess = VfsFile

internal actual fun VirtualFile.getAccessor(vfs: VfsFile) = vfs

internal actual class InternalVfsFile actual constructor(
    private val accessor: VfsFileAccess,
) {
    actual suspend fun exists(): Boolean {
        return accessor.exists()
    }

    actual suspend fun readString(): String {
        return accessor.readString()
    }

    actual suspend fun read(): ByteArray {
        return accessor.read()
    }

    actual suspend fun write(byteArray: ByteArray): Long {
        return accessor.write(byteArray)
    }

    actual suspend fun mkdir(): Boolean {
        return accessor.mkdir()
    }

    actual suspend fun mkdirs(): Boolean {
        return accessor.mkdirs()
    }

    actual suspend fun touch(): Boolean {
        accessor.touch(time = DateTime.now())
        return true
    }

    actual suspend fun delete(): Boolean {
        return accessor.delete()
    }
}
