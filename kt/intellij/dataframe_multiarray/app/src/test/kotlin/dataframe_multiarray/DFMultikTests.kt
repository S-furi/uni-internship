package dataframe_multiarray

import org.jetbrains.kotlinx.dataframe.api.columnOf
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.toColumn
import org.jetbrains.kotlinx.dataframe.api.toMap
import org.jetbrains.kotlinx.multik.api.arange
import org.jetbrains.kotlinx.multik.api.mk
import org.jetbrains.kotlinx.multik.ndarray.data.D1
import org.jetbrains.kotlinx.multik.ndarray.data.D2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class DFMultikTests {

    @Test
    fun testMultik1DNDarrayToColumn() {
        val values : NDArray<Double, D1> = mk.arange<Double>(0, 10, 1)
        val mkCol = values.toColumn()
        val expected = columnOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0)

        assertEquals(mkCol, expected)
    }

    @Test
    fun testMultik2DNDArrayToDataFrame() {
        val values: NDArray<Double, D2> = mk.arange<Double>(0, 10, 1).reshape(5, 2)
        val mkDF = values.toDataFrame()
        val expected = dataFrameOf(
            "0" to listOf(0.0, 2.0, 4.0, 6.0, 8.0),
            "1" to listOf(1.0, 3.0, 5.0, 7.0, 9.0)
        )

        assertEquals(mkDF, expected)
    }
}