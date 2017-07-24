package de.kyrtap5.mvgticker

class Test {
    fun main(args: Array<String>) {
        val ticker = MVGTicker("Hauptbahnhof")
        val deps = ticker.getDepartures(true, true, true)

        for (i in deps.indices) {
            println(deps[i].toString())
        }
    }

}