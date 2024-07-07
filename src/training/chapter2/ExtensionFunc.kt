package training.chapter2


fun String.lastChar(): Char = this.get(this.length - 1)

fun String.lastChar2(): Char = get(length - 1) // this 없이도 접근가능

fun main(args: Array<String>) {
    val c = "Hello2".lastChar()
    val c2 = "Hello2".lastChar2()

    println(c)
    println(c2)
}