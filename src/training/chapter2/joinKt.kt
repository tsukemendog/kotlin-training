package training.chapter2

fun<T> joinToString(
    collection: Collection<T>,
    separator: String = ",",  //파라미터의 디폴트 값을 지정한다.
    prefix: String = "",
    postfix: String = ""
):String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {  //this 는 수신객체를 가리킨다.
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun<T> Collection<T>.joinToString2(  //Collection(T)에 대한 확장 함수를 선언
    collection: Collection<T>,
    separator: String = ",",  //파라미터의 디폴트 값을 지정한다.
    prefix: String = "",
    postfix: String = ""
):String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {  //this 는 수신객체를 가리킨다.
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join( //문자열 컬렉션에 대해서만 호출할 수 있는 join 확장 함수
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) = joinToString(separator, prefix, postfix)

