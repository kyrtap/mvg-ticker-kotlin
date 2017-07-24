package de.kyrtap5.mvgticker

class Transport {
    enum class Type {
        BUS, TRAM, UBAHN, SBAHN
    }

    fun getTransportType(input: String): Type {
        if (input.startsWith("U"))
            return Type.UBAHN
        else if (input.startsWith("S"))
            return Type.SBAHN
        else if (input.startsWith("X"))
            return Type.BUS
        else if (input.startsWith("N"))
            return Type.BUS
        else {
            val number = Integer.parseInt(input)
            if (number < 30)
                return Type.TRAM
            else
                return Type.BUS
        }
    }
}