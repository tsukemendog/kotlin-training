package training.chapter1

import training.chapter2.lastChar2 as last  //as 를 사용해서 다른 이름으로 불러오는 것도 가능


fun main(args: Array<String>) {
    val s: String = ""
    println("max " + max(5,4))
    println("min " + min(5,4))
    println("min1 " + min1(5,4))
    println("lastChar : " + "w".last())
    val question = "테스트1" //변수 선언시 타입을 지정하지 않으면 코틀린 컴파일러가
                            //자동으로 초기화 식을 분석해서 타입을 지정해준다.
    val answer = 42;
    val yearsToCompute = 751e7

    val testVal : Int;  //초기화식이 없는 경우 반드시 타입을 명시해야 한다. val는 자바로 치면 immutable 한 final 변수
    var testVar : Int;  //mutable 한 참조다.


    var isTure = true

    val message : String
    message = if (isTure) {
        "true"
    } else {
        "false"
    }

    val message2 : String = if (isTure) "true" else "false"

    val languages = arrayListOf("Java")  //참조 자체는 불변이지만 참조하는 객체 내부는 불변이 아님
    languages.add("kotlin")

    var test2 = 42
    test2 = 43
    //test3 = "dd" //var 키워드를 사용하면 값을 바꿀 수는 있지만 초기화식에 의해 추론되거나 선언된 타입을 변경할 수는 없다.
    
    val 키득 = "문자열 템플릿"
    println("message$키득")

    val person = Person("man", true);  //new 키워드 사용없이 생성자를 호출한다.
    println("person name : ${person.name}") //프로퍼티 이름을 직접 사용해도 코틀린이 자동으로 getter 호출
    person.isMarried = false

    val rectangle = Ractangle(41,43) //생성자 호출은 언제나 괄호를 붙여야 함
    println("isSquare : ${rectangle.isSquare}")
    println("Color : ${Color.ORANGE.rgb()}")
    println("Mnemonic : ${getMnemonic(Color.GREEN)}")
    println(getWarmth(Color.ORANGE))
    println(getWarmth(Color.VIOLET))

}

fun max(a: Int, b: Int) : Int { //블록이 본문인 함수
    return if (a > b) a else b
}

fun min(a: Int, b: Int) : Int = if (a < b) a else b;  //식이 본문인 함수
/* 반환타입을 제외하면 코틀린 컴파일러가 알아서 계산해주므로타입추론(Type Inference) 도 가능하다.
대신 식이 본문인 함수에만 사용가능 */
fun min1(a: Int, b: Int) = if (a < b) a else b;

enum class Color (
    val r : Int, val g: Int, val b: Int  //상수의 프로퍼티를 정의한다.
) {
    RED(255,0,0), ORANGE(255, 165, 0), //각 상수를 생성할 때 그에 대한 프로퍼티 값을 지정한다.
    YELLOW(255,255,0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);  //여기 반드시 세미콜론을 사용해야 한다

    //enum 안에서 메서드를 정의하는 경우 반드시 enum 상수 목록과 메서드 정의 사이에 세미콜론을 넣어야 한다.
    fun rgb() = (r * 256 + g) * 256 + b //enum 클래스 안에서 메서드를 정의한다.
}

//import Color.* //짧은 이름으로 사용하기 위해 enum 상수를 모두 임포트

fun getMnemonic(color: Color) =
    when (color) {  //색이 특정 enum 상수와 같을 때 그 상수에 대응하는 문자열을 돌려준다.
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) = when(color) {
    Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
    Color.GREEN -> "neutral"
    Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
}


//코틀린의 when 은 자바의 switch 보다도 훨씬 강려크하다
fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {  //when식의 인자로 아무 객체나 사용가능하다. when은 이렇게 인자로 받은 객체가 각 분기 조건에 있는 객체와 같은지 테스트한다.
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty color")
    }

