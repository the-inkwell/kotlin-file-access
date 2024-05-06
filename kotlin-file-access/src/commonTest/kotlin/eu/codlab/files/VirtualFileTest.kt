package eu.codlab.files

import korlibs.io.async.suspendTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

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
}
