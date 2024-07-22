package training.chapter3

open class RichButton : Clickable {  //이 클래스는 열려있다. 다른 클래스가 이 클래스를 상속할 수 있다.

    fun disable() {} //이 함수는 final 이다. 하위 클래스가 이 메소드를 오버라이드할 수 없다.
    open fun animate() {} //이 함수는 열려있다. 하위 ㅋ르래스에서 이 메소드를 오버라이드해도 된다.

    final override fun click() {  //상위 클래스에서 선언된 이 함수는 열려있는 메소드를 오버라이드한다. 오버라이드한 메소드는 기본적으로 열려있다.
        TODO("Not yet implemented")  //final 이 없는 오버라이드 메소드나 프로퍼티는 기본적으로 열려있다.
    }
}