package arrbroadcasting

import org.jetbrains.kotlinx.multik.api.*
import org.jetbrains.kotlinx.multik.ndarray.data.*

import space.kscience.kmath.tensors.core.tensorAlgebra
import space.kscience.kmath.tensors.core.withBroadcast
import space.kscience.kmath.multik.MultikTensor

fun main() {
    val a: NDArray<Double, DN> = mk.arange<Double>(60).reshape(10, 6).asDNArray()
    val b: NDArray<Double, DN> = mk.arange<Double>(6).asDNArray()

    val result = a.asMultikTensor() + b.asMultikTensor()

    println(result)
}



