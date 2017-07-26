package de.kyrtap5.mvgticker

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.net.URLEncoder
import java.util.*

class MVGTicker(val station: String) {
    fun getDepartures(ubahn: Boolean, sbahn: Boolean, bus: Boolean, tram: Boolean): ArrayList<Departure> {
        var url: String = "http://www.mvg-live.de/ims/dfiStaticAuswahl.svc?haltestelle=" + URLEncoder.encode(station, "ISO-8859-1")
        if (ubahn) url += "&ubahn=checked"
        if (sbahn) url += "&sbahn=checked"
        if (tram) url += "&tram=checked"
        if (bus) url += "&bus=checked"

        val doc: Document = Jsoup.connect(url).get()
        val content: Element = doc.select("table").get(0)
        val rows: Elements = content.select("tbody").select("tr")
        val ret: ArrayList<Departure> = ArrayList<Departure>()

        for (row in rows) {
            if (row.className() == "rowOdd" || row.className() == "rowEven") {
                val cols: Elements = row.select("td")
                ret.add(Departure(cols.get(0).text(), Transport().getTransportType(cols.get(0).text()),
                        cols.get(1).text(), DateHandler().getDate(Integer.parseInt(cols.get(2).text()))))
            }
        }
        if (sbahn) ret.sort()
        return ret
    }
}