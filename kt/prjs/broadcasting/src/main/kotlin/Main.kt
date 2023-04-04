import org.jetbrains.kotlinx.multik.api.*
import org.jetbrains.kotlinx.multik.ndarray.data.*
import org.jetbrains.kotlinx.multik.api.mk

import space.kscience.kmath.tensors.core.tensorAlgebra
import space.kscience.kmath.tensors.core.withBroadcast
import space.kscience.kmath.multik.MultikTensor

// Testing array broadcasting using Kmath algebra context
// and multik NDArrays
fun main() = Double.tensorAlgebra.withBroadcast {
    val dataset: NDArray<Double, DN> = mk.arange<Double>(500).reshape(100, 5).asDNArray()

    // computing sum using KMath tensors
    val datasetTensor = MultikTensor<Double>(dataset);
    val tensorResult = datasetTensor + fromArray(
        intArrayOf(5),
        doubleArrayOf(2.0, 2.0, 2.0, 2.0, 2.0)
    )
    println(tensorResult)

    // trying to compute the broadcasting sum with two multik data structures
    val a: NDArray<Double, DN> = mk.arange<Double>(60).reshape(10, 6).asDNArray()
    val b: NDArray<Double, DN> = mk.arange<Double>(6).asDNArray()

    // apparently, using this Double Algebra context it's the broadcasting
    // is possible if the result is converted in a MultikTensor<Double>
    val mkResult = MultikTensor(a) + MultikTensor(b)

    println(mkResult)
}