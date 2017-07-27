package de.kyrtap5.mvgticker

import org.jsoup.Jsoup
import java.net.URLEncoder
import java.util.*

class MvgTicker(val station: String) {
    infix fun Date.addOffset(minuteOffset: Int): Date {
        val cal = Calendar.getInstance()
        cal.add(Calendar.MINUTE, minuteOffset)
        return cal.time
    }

    fun getDepartures(ubahn: Boolean = true, sbahn: Boolean = true, bus: Boolean = true, tram: Boolean = true): ArrayList<Departure> {
        var url = "http://www.mvg-live.de/ims/dfiStaticAuswahl.svc?haltestelle=" + URLEncoder.encode(station, "ISO-8859-1")
        if (ubahn) url += "&ubahn=checked"
        if (sbahn) url += "&sbahn=checked"
        if (tram) url += "&tram=checked"
        if (bus) url += "&bus=checked"

        val doc = Jsoup.connect(url).get()
        if (doc.select("td:contains(Es wurde kein Bahnhof mit diesem Namen gefunden.)").first() != null)
            throw Exception("Station not found")
        val content = doc.select("table").get(0)
        val rows = content.select("tbody").select("tr")
        val ret = ArrayList<Departure>()

        for (row in rows) {
            if (row.className() == "rowOdd" || row.className() == "rowEven") {
                val cols = row.select("td")
                ret.add(Departure(cols.get(0).text(), Transport().getTransportType(cols.get(0).text()),
                        cols.get(1).text(), Date() addOffset Integer.parseInt(cols.get(2).text())))
            }
        }
        if (sbahn) ret.sort()
        return ret
    }
}