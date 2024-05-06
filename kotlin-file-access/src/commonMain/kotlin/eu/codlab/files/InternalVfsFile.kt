package eu.codlab.files

import korlibs.io.file.VfsFile

internal expect class InternalVfsFile(vfsFile: VfsFile) {
    suspend fun exists(): Boolean
    suspend fun readString(): String
    suspend fun read(): ByteArray
    suspend fun write(byteArray: ByteArray): Long
    suspend fun mkdir(): Boolean
    suspend fun mkdirs(): Boolean
    suspend fun touch(): Boolean
    suspend fun delete(): Boolean
}
