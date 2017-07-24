package de.kyrtap5.mvgticker

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import java.net.URLEncoder

class MVGTicker(val station: String) {
    fun getDepartures(ubahn: Boolean, bus: Boolean, tram: Boolean): Array<Departure?> {
        var url: String = "http://www.mvg-live.de/ims/dfiStaticAuswahl.svc?haltestelle=" + URLEncoder.encode(station, "ISO-8859-1")
        if (ubahn) url += "&ubahn=checked"
        if (bus) url += "&bus=checked"
        if (tram) url += "&tram=checked"

        val doc: Document = Jsoup.connect(url).get()
        val content: Element = doc.select("table").get(0)
        val rows: Elements = content.select("tbody").select("tr")
        var ret: Array<Departure?> = arrayOfNulls<Departure?>(rows.size - 2)

        for (i in 1..(rows.size - 2)) {
            val row: Element = rows.get(i)
            val cols: Elements = row.select("td")
            ret[i - 1] = Departure(cols.get(0).text(), Transport().getTransportType(cols.get(0).text()),
                    cols.get(1).text(), DateHandler().getDate(Integer.parseInt(cols.get(2).text())))
        }
        return ret
    }
}