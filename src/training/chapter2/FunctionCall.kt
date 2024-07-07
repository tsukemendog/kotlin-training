package training.chapter2


fun main(args: Array<String>){
    val list = listOf(1,2,3)
    println(joinToString(list, separator = "; ", prefix = "{", postfix = ")"))
    println(joinToString(list, prefix = "[", postfix = "]"))
    
    println(listOf("1","2","3").join(" "))
    // println(listOf(1,2,3).join(" ")) 이건 안됨

    val view: View = Button()
    view.showOff()  //확장함수는 정적으로 결정된다.
    // 확장함수는 결국 첫번 째 인자가 수신 객체로 받는 정적 자바 메소드로 기억하면 된다.
}


open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() {
        println("Button clicked")
    }
}

fun View.showOff() = println("I'm a View")
fun Button.showOff() = println("I'm a Button")