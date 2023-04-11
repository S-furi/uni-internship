import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import ucar.nc2.NetcdfFiles
import java.io.IOException
import java.util.Collections

class ioTests {

    @Test
    fun testReadingFile() {
        try {
            val path: String = "./test"
            val ncfile = NetcdfFiles.open(path)
            val elements: DoubleArray = ncfile.readSection("temperature").copyTo1DJavaArray() as DoubleArray
            val comparing = Array<Double>(128 * 64) { it * 100000.0 }

            assertTrue(comparing.toList().containsAll(elements.toList()))
        } catch (e: IOException) {
            println("File \'test\' not found in project directory!")
            e.printStackTrace()
        }
    }
}