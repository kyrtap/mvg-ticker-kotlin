package de.kyrtap5.mvgticker
import java.text.SimpleDateFormat
import java.util.*

class DateHandler {
    fun getDate(minuteOffset: Int): Date {
        val cal: Calendar = Calendar.getInstance()
        cal.add(Calendar.MINUTE, minuteOffset)
        return cal.time
    }

    fun formatDate(date: Date, format: String): String {
        return SimpleDateFormat(format).format(date)
    }
}