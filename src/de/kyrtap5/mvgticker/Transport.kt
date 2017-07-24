package de.kyrtap5.mvgticker

class Transport {
    enum class Type {
        BUS, TRAM, UBAHN, SBAHN
    }

    fun getTransportType(input: String): Type {
        when {
            input.startsWith("U") -> return Type.UBAHN
            input.startsWith("S") -> return Type.SBAHN
            input.startsWith("X") -> return Type.BUS
            input.startsWith("N") -> return Type.BUS
            Integer.parseInt(input) < 30 -> return Type.TRAM
            else -> return Type.BUS
        }
    }
}