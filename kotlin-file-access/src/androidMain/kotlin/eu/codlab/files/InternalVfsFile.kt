package eu.codlab.files

import korlibs.io.file.VfsFile
import korlibs.time.DateTime

internal actual class InternalVfsFile actual constructor(val vfsFile: VfsFile) {
    actual suspend fun exists(): Boolean {
        return vfsFile.exists()
    }

    actual suspend fun readString(): String {
        return vfsFile.readString()
    }

    actual suspend fun read(): ByteArray {
        return vfsFile.read()
    }

    actual suspend fun write(byteArray: ByteArray): Long {
        return vfsFile.write(byteArray)
    }

    actual suspend fun mkdir(): Boolean {
        return vfsFile.mkdir()
    }

    actual suspend fun mkdirs(): Boolean {
        return vfsFile.mkdirs()
    }

    actual suspend fun touch(): Boolean {
        vfsFile.touch(time = DateTime.now())
        return true
    }

    actual suspend fun delete(): Boolean {
        return vfsFile.delete()
    }
}
