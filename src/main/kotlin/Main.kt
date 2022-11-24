import java.util.*
//https://app.codesignal.com/arcade/intro/level-7/PTWhv2oWqd6p4AHB9/solutions
fun main() {
    print(
        solution(
            mutableListOf(
                "abc",
                "abx",
                "axx",
                "abc"
            )
        )
    )
}



fun solution(inputArray: MutableList<String>): Boolean {
    val temp = permutations(inputArray)
    if (temp.size < inputArray.size) return false
    temp.forEach {
        println(it.joinToString { it })
        var count = 0
        for (i in 0 until it.size - 1) {
            var innerCount = 0
            for (j in 0 until it[i].length) {
                print(Math.abs(it[i][j].code - it[i + 1][j].code).toString() + " ")
                if (Math.abs(it[i][j].code - it[i + 1][j].code) > 0) {
                    innerCount++
                }
            }
            println()

            println("${it[i]} , ${it[i + 1]} , $innerCount")

            if (innerCount == 1) {
                count++
            }
        }
        println()
        if (count == it.size - 1)
            return true
    }

    return false
}

fun permutations(input: MutableList<String>): MutableList<MutableList<String>> {
    val solutions = mutableListOf<MutableList<String>>()
    permutationsRecursive(input, 0, solutions)
    return solutions
}

fun permutationsRecursive(input: MutableList<String>, index: Int, answers: MutableList<MutableList<String>>) {
    if (index == input.lastIndex) answers.add(input.toMutableList())
    for (i in index .. input.lastIndex) {
        Collections.swap(input, index, i)
        permutationsRecursive(input, index + 1, answers)
        Collections.swap(input, i, index)
    }
}