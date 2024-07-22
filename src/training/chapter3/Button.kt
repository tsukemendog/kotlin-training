package training.chapter3

//인터페이스는 개수상관없이 구현가능하지만 클래스는 하나만 상속가능
class Button : Clickable, Focusable {  //자바에서는 extends 와 implements 키워드를 사용하지만 코틀린에서는 콜론을 붙인다.
    override fun click() = println("I was clicked")  //override 변경자는 꼭 사용한다.

    override fun showOff() {
        super<Clickable>.showOff()  //이름과 시그니처가 같은 멤버 메소드에 대해 둘 이상의 디폴트 구현이 있는 경우 인터페이스를 구현하는
                                    //하위 클래스에서 명시적으로 새로운 구현을 제공해야 한다.
        super<Focusable>.showOff()  //상위타입의 이름을 꺾쇠 괄호사이에 넣어서 "super" 를 지정하면 어떤 상위 타입의 멤버 메소드를 호출할지 지정할 수 있다.
    }

    //override fun showOff() = super<Clickable>.showOff() //상속한 구현중 단 하나만 구현하고 싶다면 이렇게 해도 ㄱㅊ
}