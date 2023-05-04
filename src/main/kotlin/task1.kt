fun main() {
    println(agoToText(55))
    println(agoToText(190))
    println(agoToText(7000))
    println(agoToText(86401))
    println(agoToText(172800))
    println(agoToText(9847000))
}

fun agoToText(second: Int) = when (second) {
    in 1..60 -> "был(а) только что"
    in 61..(60 * 60) -> endingMin(second)
    in (60 * 60 + 1)until(24 * 60 * 60) -> endingHour(second)
    in (24 * 60 * 60)until(48 * 60 * 60) -> "был(а) вчера"
    in (48 * 60 * 60)until(72 * 60 * 60) -> "был(а) позавчера"
    else -> "был(а) давно"
}

fun endingHour(second: Int): String {
    val hour = second / 60 / 60
    return when {
        hour %10 == 1 && hour % 100 != 11 -> "был(а) в сети $hour час назад"
        hour %10 in 2..4 && hour % 100 !in 12..14 -> "был(а) в сети $hour часа назад"
        else -> "был(а) в сети $hour часов назад"
    }
}

fun endingMin(second: Int): String {
    val min = second / 60
    return when {
        min % 10 == 1 && min % 100 != 11 -> "был(а) $min минуту назад"
        min % 10 in 2..4 && min % 100 !in 12..14 -> "был(а) $min минуты назад"
        else -> "был(а) $min минут назад"
    }
}