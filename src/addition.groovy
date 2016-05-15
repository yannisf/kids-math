// A + B

minA = 1
maxA = 10

minB = 2
maxB = 10

maxSum = 20
printFirst = 20

additions = [];

(minA..maxA).each { i ->
    (minB..maxB).find { ii ->
        additions << "$i + $ii"
        i + ii >= maxSum
    }
}

Collections.shuffle(additions)

normalizedPrintFirst = printFirst < additions.size() ? printFirst - 1 : additions.size()
additions.subList(0, normalizedPrintFirst).each {
    println "$it = "
}