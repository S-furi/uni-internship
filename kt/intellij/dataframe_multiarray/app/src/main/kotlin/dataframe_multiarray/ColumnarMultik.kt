package dataframe_multiarray

import org.jetbrains.kotlinx.dataframe.AnyCol
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.toColumn
import org.jetbrains.kotlinx.dataframe.api.toColumnOf
import org.jetbrains.kotlinx.multik.ndarray.data.D1
import org.jetbrains.kotlinx.multik.ndarray.data.D2
import org.jetbrains.kotlinx.multik.ndarray.data.NDArray
import org.jetbrains.kotlinx.multik.ndarray.operations.toList
import org.jetbrains.kotlinx.multik.ndarray.operations.toListD2

inline fun <reified T> NDArray<T, D2>.toDataFrame() : DataFrame<*> {
    val columns = this.transpose().toListD2().mapIndexed { idx, elems -> elems.toColumnOf<T>("$idx")}
    return dataFrameOf(columns)
}

inline fun <reified T> NDArray<T, D1>.toColumn() : AnyCol = this.toList().toColumn()