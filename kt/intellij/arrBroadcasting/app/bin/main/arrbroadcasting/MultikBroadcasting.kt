package arrbroadcasting

import org.jetbrains.kotlinx.multik.api.*
import org.jetbrains.kotlinx.multik.ndarray.data.*
import space.kscience.kmath.multik.MultikTensor
import space.kscience.kmath.tensors.core.DoubleTensorAlgebra
import space.kscience.kmath.tensors.core.tensorAlgebra
import space.kscience.kmath.tensors.core.withBroadcast
import space.kscience.kmath.tensors.core.DoubleTensor

fun NDArray<Double, DN>.asMultikTensor(): MultikTensor<Double> = MultikTensor(this)

fun simpleAdd(a: MultikTensor<Double>, b: MultikTensor<Double>): DoubleTensor? {
    var res: DoubleTensor? = null
    Double.tensorAlgebra.withBroadcast {
        res =  a + b
    }
    return res
}

// need checks for broadcastability
operator fun MultikTensor<Double>.plus(other: MultikTensor<Double>): DoubleTensor? {
    return simpleAdd(this, other)
}
