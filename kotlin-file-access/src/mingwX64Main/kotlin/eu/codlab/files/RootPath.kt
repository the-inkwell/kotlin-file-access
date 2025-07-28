package eu.codlab.files

import korlibs.io.lang.Environment
import korlibs.io.lang.expand

actual val RootPath = Environment.expand("~")
