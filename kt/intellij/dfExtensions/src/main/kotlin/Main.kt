import kotlinx.datetime.LocalDate
import utils.toList
import org.jetbrains.kotlinx.dataframe.*
import org.jetbrains.kotlinx.dataframe.api.columnOf
import org.jetbrains.kotlinx.dataframe.api.explode


fun main(args: Array<String>) {

    val start = LocalDate(2023, 4, 4)
    val end = LocalDate(2023, 5, 4)

    val dates = (start..end).toList()

    println(columnOf(dates).explode())
}