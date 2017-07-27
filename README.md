# MVG Ticker
#### Simple MVG (Münchner Verkehrsgesellschaft) live data parser written in Kotlin.
## What can I use it for?
You can use MVG Ticker to get the upcoming departures from the desired bus/tram/subway station. The output will be an ArrayList of Departure objects with the data parsed from the MVG live website. A Departure object contains the line, its type, its destination and the departure time.
## How can I use it?
Example usage:
```
val deps = MvgTicker("Hauptbahnhof").getDepartures()
for (d in deps) println(d.toString())
```
