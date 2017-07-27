package de.kyrtap5.mvgticker

import java.text.SimpleDateFormat
import java.util.*

class Departure(val line: String, val type: Transport.Type, val destination: String, val departure: Date) : Comparable<Departure> {
    fun Date.formatDate(format: String): String = SimpleDateFormat(format).format(this)
    infix fun Date.getDifference(earlier: Date) = ((this.getTime() / 60000) - (earlier.getTime() / 60000)).toInt()

    override fun toString(): String {
        return "Linie: " + line + " (" + type.toString() + ")\t" +
                "Ziel: " + destination + "\t" +
                "Abfahrt: " + departure.formatDate("HH:mm") + " (${this.getRemainingTime()})"

    }

    override fun compareTo(other: Departure): Int = departure.compareTo(other.departure)

    fun getRemainingTime(): Int = departure.getDifference(Date())
}