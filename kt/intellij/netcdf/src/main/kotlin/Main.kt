import ucar.ma2.DataType
import ucar.nc2.Attribute
import ucar.nc2.write.NetcdfFormatWriter
import ucar.ma2.Array
import ucar.ma2.Index
import ucar.nc2.Dimension
import ucar.nc2.NetcdfFiles
import ucar.nc2.Variable
import java.io.IOException

fun printFile(writer: NetcdfFormatWriter) {
    println(writer.outputFile)
}

fun testReadingFile(path: String) {
    try {
        val ncfile = NetcdfFiles.open(path)
        val elements: DoubleArray = ncfile.readSection("temperature").copyTo1DJavaArray() as DoubleArray


    } catch (e: IOException) {
        println("Error opening test file: \n ${e.message}")
        e.printStackTrace()
    }
}

fun main() {
    val builder = NetcdfFormatWriter.createNewNetcdf3("./test")

    val latDim = builder.addDimension("lat", 64)
    val lonDim = builder.addDimension("lon", 128)

    val dims = listOf(latDim, lonDim)

    val varBuilder = builder.addVariable("temperature", DataType.DOUBLE, dims)
    // add attribute to variables
    varBuilder.addAttribute(Attribute("units", "K"))

    // adding sample data as 1D Array of 3 elements
    val data = Array.makeArray(DataType.DOUBLE, arrayOf("1", "2", "3"))

    // setting attribute with name "scale" and values [1, 2, 3]
    // and adding them to the temperature variables
    varBuilder.addAttribute(Attribute.builder("scale").setValues(data).build())

    // creating another variable of type char with length 80
    val svar_len: Dimension = builder.addDimension("svar_len", 80)
    builder.addVariable("svar", DataType.CHAR, "svar_len")

    // create a 2D variable named "names" of type CHAR with length 3
    val names: Dimension = builder.addDimension("names", 3)
    builder.addVariable("names", DataType.CHAR, "names svar_len")

    // scalar variable, an empty array list denotes the scalar type (no dimension)
    builder.addVariable("scalar", DataType.DOUBLE, ArrayList<Dimension>())

    val file = builder.build()
    printFile(file)

    // adding data
    val variable: Variable? = file.findVariable("temperature")

    if (variable == null) {
        println("Variable \'temperature\' not found!")
    }

    val shape: Pair<Int, Int> = Pair(variable!!.shape[0], variable!!.shape[1])
    val elem = DoubleArray(shape.first * shape.second) { it * 100000.0 }

    val a = Array.factory(DataType.DOUBLE, shape.toList().toIntArray(), elem)

    // writing new data to the opened file
    file.write(variable, intArrayOf(0, 0), a)

    // if print is called on the output file,
    // no changes should appear because a read method would be called.
    // by now, it raises exceptions....
    file.close()

    testReadingFile("./test")
}