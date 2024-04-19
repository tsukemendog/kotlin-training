package training.chapter1

import java.io.BufferedReader
import java.io.StringReader
import java.util.TreeMap


fun main(args: Array<String>) {
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    for (i in 1..100) {
        print(fizzBuzz(i))
    }

    for (i in 100 downTo  1 step 2) {  //100에서 1까지 2스텝씩 간다. (step 2 는 절대값이 2로 바뀌지만 방향은 불변 고로 -2씩 증가)
        print(fizzBuzz(i))
    }

    iterationForMap();
    iterationForArray()
    println(isLetter('q'))
    println(isNotDigit('x'))

    readNumber(BufferedReader(StringReader("Not a Number")))
}

class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

interface Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num  //일단은 적어놓지만 as 를 이용한 타입변환은 필요없다.
        return n.value
    }

    if (e is Sum) {  //하지만 is를 사용하기 위해서는 프로퍼티가 반드시 val여야하고 커스텀 접근자도 사용하면 안된다.
        return eval(e.right) + eval(e.left)
    }

    throw IllegalArgumentException("Unknown expression")
}


//중괄호와 return 키워드를 생략가능
fun evel2 (e : Expr) : Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.right) + eval(e.left)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }


fun evel3 (e : Expr) : Int =
    when (e) {
        is Num ->
            e.value
        is Sum ->
            eval(e.right) + eval(e.left)
        else ->
            throw IllegalArgumentException("Unknown expression")
    }

/*while (condition) {
    //조건이 참일동안 실행
}

do {
    //조건의 유무와 관계없이 첫번째는 무조건 실행, 이후부터는 조건에 따라 실행

} while(condition)*/



fun fizzBuzz(i: Int) = when {  //인자가 없는 when
    i % 15 == 0 -> " FizzBuzz "
    i % 3 == 0 -> " Fizz "
    i % 5 == 0 -> " Buzz "
    else -> "$i "
}

fun iterationForMap() {
    val binaryReps = TreeMap<Char, String>()  //키에 대해 정렬하기 위해 TreeMap 을 사용한다.
    for (c in 'A'..'F') {  //A부터 F까지 문자의 범위를 사용해 이터레이션한다.
        val binary = Integer.toBinaryString(c.toInt()) //아스키코드를 2진표현으로 바꾼다.
        binaryReps[c] = binary  //c를 키로 c의 2진 표현을 맵에 넣는다.
    }

    for ((letter, binary) in binaryReps) {
        println("$letter : $binary")
    }
}

fun iterationForArray() {
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {
        println("$index: $element")
    }
}


//in으로 컬렉션이나 범위의 원소 검사
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'
//c in 'a'..'z'  -> 'a' <= c && c <= 'z' 로 변환된다

fun recognize(c: Char) = when(c) {
    in '0'..'9' -> "It's a digit!"  //c 값이 0부터 9사이에 있는지 검사한다.
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"  //여러 범위 조건을 함께 사용해도 된다.
    else -> "I don't know.."
}

fun throwTest(number: Number) {
    val percentage =
        if (number in 0..100)
            number
        else
            throw IllegalArgumentException ("")  //throw 도 식이다.
}


//자바코드와 가장 큰 차이는 throws 절이 코드에 없다는 거다.
//자바에서는 체크예외(IOException 등) 를 명시적으로 처리해야 한다.
fun throwTest2(reader: BufferedReader): Int? { //함수가 던질 수 있는 예외를 명시할 필요가 없다.
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e : NumberFormatException) {  //예외 타입을 :의 오른쪽에 쓴다.
        return null
    }
    finally {  //finally 는 자바와 똑같이 작동한다.
        reader.close()
    }
}

fun readNumber(reader: BufferedReader) {
    val number = try {  //if와 달리 try 는 반드시 중괄호로 둘러싸야 한다.
        //다른 문장과 마찬가지로 try 본문도 내부에 여러 문장이 있으면 마지막 식의 값이 전체 결과 값이다.
        Integer.parseInt(reader.readLine())  //이 식의 값이 try 식의 값이 된다.
    } catch (e: NumberFormatException) {
        //return  //return 문을 만들면 예외가 발생한 경우 catch 블록 다음코드는 실행이 안 된다.
        null  //하지만 계속 진행하고 싶다면 catch 블록도 값을 만들어야한다. catch도 마지막 식이 블록 전체의 값이 된다.
        //예외가 발생하면 null 값을 사용한다.
    }
    println(number)

    //try 코드의 블록 실행이 정상적으로 끝나면 그 블록의 마지막 식의 값이 결과다.
}