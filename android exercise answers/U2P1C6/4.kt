fun main() {
    printFinalTemperature(27.0, "C", "F")
    printFinalTemperature(350.0, "K", "C")
    printFinalTemperature(10.0, "F", "K")
}


fun printFinalTemperature(
    initialMeasurement: Double, 
    initialUnit: String, 
    finalUnit: String, 
    conversionFormula: (Double) -> Double =
        when {
            initialUnit == "C" -> if (finalUnit == "F") {cToFConversion} else {cToKConversion}
            initialUnit == "K" -> if (finalUnit == "F") {kToFConversion} else {kToCConversion}
            else -> if (finalUnit == "C") {fToCConversion} else {fToKConversion}
        }
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}


val cToFConversion: (Double) -> Double = {
    it * 9 / 5 + 32
}

val cToKConversion: (Double) -> Double = {
    it + 273.15
}

val fToCConversion: (Double) -> Double = {
    (it - 32) * (5 / 9)
}

val fToKConversion: (Double) -> Double = {
    (it - 32) * (5 / 9) + 273.15
}

val kToCConversion: (Double) -> Double = {
    it - 273.15
}

val kToFConversion: (Double) -> Double = {
    (it - 273.15) * (9 / 5) + 32
}