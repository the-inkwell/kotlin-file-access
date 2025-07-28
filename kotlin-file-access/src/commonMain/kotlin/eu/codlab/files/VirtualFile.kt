package eu.codlab.files

import korlibs.io.file.VfsFile
import korlibs.io.file.std.localVfs

class VirtualFile {
    companion object {
        val Root = VirtualFile(RootPath)
    }

    private val path: String
    private val file: String?
    private val vfs: VfsFile
    private val internalVfsWrapper: InternalVfsFile

    constructor(file: String) {
        path = file
        this.file = null
        this.vfs = localVfs(path, true)
        internalVfsWrapper = InternalVfsFile(getAccessor(vfs))
    }

    constructor(path: String, file: String) {
        this.path = path
        this.file = file

        this.vfs = localVfs("$path/$file", true)
        internalVfsWrapper = InternalVfsFile(getAccessor(vfs))
    }

    constructor(virtualFile: VirtualFile) {
        path = virtualFile.path
        file = virtualFile.file
        vfs = localVfs("$path/$file", true)
        internalVfsWrapper = InternalVfsFile(getAccessor(vfs))
    }

    constructor(virtualFile: VirtualFile, file: String) : this(virtualFile.absolutePath, file)

    val absolutePath: String
        get() = if (null != file) {
            "$path/$file"
        } else {
            path
        }

    suspend fun mkdirs() {
        internalVfsWrapper.mkdirs()
    }

    suspend fun readString(): String {
        return internalVfsWrapper.readString()
    }

    suspend fun read(): ByteArray {
        return internalVfsWrapper.read()
    }

    suspend fun exists(): Boolean {
        return internalVfsWrapper.exists()
    }

    suspend fun write(bytes: ByteArray) {
        internalVfsWrapper.write(bytes)
    }

    suspend fun touch() {
        internalVfsWrapper.touch()
    }

    suspend fun delete() {
        internalVfsWrapper.delete()
    }
}
