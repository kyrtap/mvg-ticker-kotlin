package de.kyrtap5.mvgticker

import java.util.*

class Departure(val line: String, val type: Transport.Type, val destination: String, val departure: Date) : Comparable<Departure> {

    override fun toString(): String {
        return "Linie: " + line + " (" + type.toString() + ")\t" +
                "Ziel: " + destination + "\t" +
                "Abfahrt: " + DateHandler().formatDate(departure, "HH:mm")
    }

    override fun compareTo(other: Departure): Int {
        return departure.compareTo(other.departure)
    }
}