package training.chapter2

val set = hashSetOf(1,7,15)

val list = arrayListOf(1,7,15)

//to가 제공하는건 특별 키워드가 아니라 일반 함수라는 것에 유의하자
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")


fun main(args: Array<String>) {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)  // 코틀린은 자신만의 컬렉션 기능을 제공하지 않고 자바의 기능을 쓴다.
    println(strings.last())
    println(members.max())

    val strings2 = listOf("first", *args)  //스프레드 연산자가 배열의 내용을 펼쳐준다.


    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")  //이 코드는 중위 호출이라는 특별한 방식으로 to 라는 일반 메소드를 호출한 것이다.
    1.to("one")  //to 메소드를 일반적인 호출 방식으로 호출함
    1 to "one" //to 메소드를 중위호출 방식으로 호출함

    // 인자가 하나뿐인 일반 메소드나 인자가 하나뿐인 확장 함수에 중위 호출을 사용할 수 있다.
    val (number, name) = 1 to "one"

    //Pair의 내용으로 두 변수를 즉시 초기화할 수 있는데 이를 구조 분해 선언이라고 한다.


    val kotlinLogo = """|  ?//
                        .|  ? //
                        .|  ?/\
    """.trimMargin(".") // 그 이외에도 삼중 따옴표 문자열은 이스케이프 걱정없이 요긴하게 사용가능하다. 자바스크립트의 `` 문자열과 비슷

    println(kotlinLogo)

}

val strings = listOf("first", "second", "fourteenth")  //vararg 는 가변인자를 받아주는 키워드이다

val members = setOf(1,14,2)

infix fun Any.to(other: Any) = Pair(this, other)  //함수를 중위 호출에 사용하게 허용하고 싶으면 infix 변경자를 함수 선언 앞에 추가


