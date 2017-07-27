package de.kyrtap5.mvgticker

class Transport {
    enum class Type {
        UBAHN, SBAHN, TRAM, BUS, NACHTBUS, EXPRESSBUS
    }

    fun getTransportType(input: String): Type = when {
        input.startsWith("U") -> Type.UBAHN
        input.startsWith("S") -> Type.SBAHN
        input.startsWith("X") -> Type.EXPRESSBUS
        input.startsWith("N") -> Type.NACHTBUS
        Integer.parseInt(input) < 30 -> Type.TRAM
        else -> Type.BUS
    }
}