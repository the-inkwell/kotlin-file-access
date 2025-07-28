package eu.codlab.files

import korlibs.io.file.VfsFile

expect class VfsFileAccess

internal expect fun VirtualFile.getAccessor(vfs: VfsFile): VfsFileAccess

internal expect class InternalVfsFile(
    accessor: VfsFileAccess,
) {
    suspend fun exists(): Boolean

    suspend fun readString(): String

    suspend fun read(): ByteArray

    suspend fun write(byteArray: ByteArray): Long

    suspend fun mkdir(): Boolean

    suspend fun mkdirs(): Boolean

    suspend fun touch(): Boolean

    suspend fun delete(): Boolean
}
