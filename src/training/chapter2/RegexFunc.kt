package training.chapter2

fun parsePath(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()  //삼중 따옴표에서는 이스케이프 할 필요가 전혀 없다.
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured  //구조분해 선언
        println("Dir: $directory, name: $filename, ext: $extension")
    }

}