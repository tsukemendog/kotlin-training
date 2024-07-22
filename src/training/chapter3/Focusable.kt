package training.chapter3

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"}")
    fun showOff() = println("I'm focusable!")
}