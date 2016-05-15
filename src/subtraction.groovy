// A - B

minA = 4
maxA = 10

minB = 2
maxB = 10

printFirst = 20

subtractions = [];

(minA..maxA).each { i ->
    (minB..maxB).find { ii ->
        subtractions << "$i - $ii"
        ii >= i
    }
}

Collections.shuffle(subtractions)

subtractions.subList(0, printFirst - 1).each {
    println "$it = "
}