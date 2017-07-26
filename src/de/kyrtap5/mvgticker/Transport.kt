package de.kyrtap5.mvgticker

class Transport {
    enum class Type {
        BUS, TRAM, UBAHN, SBAHN
    }

    fun getTransportType(input: String): Type = when {
        input.startsWith("U") -> Type.UBAHN
        input.startsWith("S") -> Type.SBAHN
        input.startsWith("X") -> Type.BUS
        input.startsWith("N") -> Type.BUS
        Integer.parseInt(input) < 30 -> Type.TRAM
        else -> Type.BUS
    }
}