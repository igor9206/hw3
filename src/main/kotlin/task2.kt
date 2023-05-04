fun main() {
    println(transfer(sumTransfer = 1000))
    println(transfer("Maestro", 75001, 1000))
    println(transfer("Visa", 5000, 10000))
    println(transfer("UnionPay", 5000, 10000))
}

fun transfer(typeCard: String = "VK Pay", sumMonth: Int = 0, sumTransfer: Int) : String {
    val masterMaestroMonthLimit = 75_000
    val visaMirMinCommissionRub = 35
    val zeroCommission = 0

    val commissionMasterMaestro = 0.006 * sumTransfer + 20
    val commissionVisaMir = 0.0075 * sumTransfer

    return when (typeCard) {
        "VK Pay" -> "$zeroCommission"
        "MasterCard", "Maestro" ->
            if (sumMonth > masterMaestroMonthLimit) "$commissionMasterMaestro" else "$zeroCommission"
        "Visa", "Mir" ->
            if (commissionVisaMir < visaMirMinCommissionRub) "$visaMirMinCommissionRub" else "$commissionVisaMir"

        else -> "Invalid typeCard name"
    }
}