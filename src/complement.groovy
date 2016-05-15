// A + B = C

minA = 1
maxA = 9

minB = 1
maxB = 9

maxSum = 16
printFirst = 21

nbsp = "&nbsp;"
border =  "style='border:thin black solid; padding: 1em'"
divStyle = "style='font-family:monospace; font-size: 28pt; font-weight: bold; padding: 0.2em; margin: 0 2em 1em 0; display: inline-block'"


triplets = [];

(minA..maxA).each { i ->
    (minB..maxB).find { ii ->
        sum = i + ii
        triplets << [i<10?"$nbsp$i":"$i", ii<10?"$nbsp$ii":"$ii", sum<10?"$nbsp$sum":"$sum"]
        sum >= maxSum
    }
}

Random random = new Random(new Date().getTime())
triplets.each { i ->
    hidePosition = random.nextInt(3)
    i[hidePosition] = "$nbsp$nbsp"
}

Collections.shuffle(triplets)

file = new File('/home/yannis/Desktop/complement.html')
file.text = ''

normalizedPrintFirst = printFirst <= triplets.size() ? printFirst : triplets.size()
triplets.subList(0, normalizedPrintFirst).each { i ->
    table = "<div $divStyle><table><tr><td $border>${i[0]}</td><td>$nbsp</td><td $border>${i[1]}</td></tr><tr><td>$nbsp</td><td $border>${i[2]}</td><td>$nbsp</td></tr></table></div>"
    file.append table
}