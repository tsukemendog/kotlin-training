package training.chapter3

import java.io.Serializable

internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

/*
public 멤버가 자신의 internal 수신타입인 TalkativeButton 을 노출하기에 오류가남
fun TalkativeButton.giveSpeech() { 
    
    yell()  //yell 은 수신타입의 private 멤버임
    whisper() //휘스퍼는 수신타입의 protected 멤버임
}


*/


interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}


//코틀린 중첩 클래스에 아무런 변경자가 붙지 않으면 자바 static 중첩 클래스와 같다.
//자바 static class 코틀린의 class
//자바 class 코틀린은 inner class

//Inner 안에서 바깥쪽 클래스 Outer 의 참조에 접근하려면 this@Outer 라고 써야한다.
class Outer {
    inner class Inner {
        fun getOuterRef(): Outer = this@Outer
    }
}



sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int = when (e) {
    is Num -> e.value
    is Sum -> eval(e.right) + eval(e.left)
    else ->  //else 분기가 꼭 있어야한다.
        throw IllegalArgumentException("Unknown Exception")
}


sealed class Expr2 {  //기반 클래스를 sealed 로 봉인하고 하위클래스는 반드시 기반클래스 안에 중첩시켜야한다. 그리고 sealed 는 자동으로 오픈이다.
    class Num(val value: Int) : Expr2()
    class Sum(val left: Expr, val right: Expr) : Expr2()
}