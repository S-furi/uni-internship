package utils;

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.daysUntil
import kotlinx.datetime.plus
import java.time.temporal.TemporalAmount

class DateRange(start: LocalDate, private val end: LocalDate, private val step: Int): Iterator<LocalDate> {
    private var current: LocalDate = start;

    override fun hasNext(): Boolean = this.current != end

    override fun next(): LocalDate {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val res = this.current
        this.current = this.current.plus(this.step, DateTimeUnit.DayBased(1))
        return res
    }
}

operator fun ClosedRange<LocalDate>.iterator() = DateRange(this.start, this.endInclusive, 1)

fun ClosedRange<LocalDate>.toList(): List<LocalDate> {
    return when(val size = this.start.daysUntil(this.endInclusive))  {
        0 -> emptyList()
        1 -> listOf(this.iterator().next())
        else -> {
            val res = ArrayList<LocalDate>()
            for (elem in this) {
                res.add(elem)
            }
            return res
        }
    }
}