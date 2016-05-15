// A + B + C

minA = 2
maxA = 9

minB = 3
maxB = 8

minC = 4
maxC = 7

maxSum = 12
printFirst = 20

additions = [];

(minA..maxA).each { i ->
    (minB..maxB).each { ii ->
        (minC..maxC).find { iii ->
            element = [i, ii, iii]
            Collections.shuffle(element)
            additions << element
            i + ii + iii >= maxSum
        }
    }
}

Collections.shuffle(additions)

normalizedPrintFirst = printFirst < additions.size() ? printFirst - 1 : additions.size()
additions.subList(0, normalizedPrintFirst).each {
    println "${it[0]} + ${it[1]} + ${it[2]} = "
}