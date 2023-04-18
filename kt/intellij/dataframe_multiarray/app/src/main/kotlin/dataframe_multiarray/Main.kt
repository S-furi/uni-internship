package dataframe_multiarray

import org.jetbrains.kotlinx.multik.api.*
import org.jetbrains.kotlinx.multik.ndarray.data.*

fun main() {
    val values : NDArray<Double, D2> = mk.arange<Double>(0, 10, 1).reshape(5, 2)
    println(values.toDataFrame())
}
