package training.chapter3

abstract class Animated {  //이 클래스는 추상클래스다. 이 클래스의 인스턴스를 만들 수 없다.
    abstract fun animate() //이 함수는 추상 함수다. 이 함수에는 구현이 없다. 하위 클래스에서는 이 함수를 반드시 오버라이드해야 한다.

    open fun stopAnimating() {  //추상 클래스에 속했더라도 비추상 함수는 기본적으로 파이널이지만 원한다면 open 으로 오버라이드를 허용할 수 있다.

    }

    fun animateTwice() {

    }
}