package eu.codlab.files

import korlibs.io.lang.toByteArray
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class VirtualFileTest {
    @Test
    fun testName() {
        val fileName = "fileName"
        val vfsFile = VirtualFile(fileName)
        assertEquals(fileName, vfsFile.absolutePath)

        val vfsFileFromVirtualFile = VirtualFile(vfsFile)
        assertEquals(fileName, vfsFileFromVirtualFile.absolutePath)

        listOf(
            VirtualFile("path", fileName),
            VirtualFile(VirtualFile("path"), fileName)
        ).forEach {
            assertEquals("path/$fileName", it.absolutePath)
        }
    }

    @Test
    fun testWrite() = runTest {
        val fileName = "fileName"
        val vfsFile = VirtualFile(RootPath, fileName)

        println(vfsFile.absolutePath)
        vfsFile.write("test".toByteArray())
    }
}
