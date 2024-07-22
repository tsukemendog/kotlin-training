package training.chapter3

interface Clickable {
    fun click()  //일반 메소드
    fun showOff() = println("I'm clickable!")  //디폴트 구현 메소드

    /*
    * 인터페이스 멤버의 경우 final, open, abstract 를 사용하지 않는다.
    * 인터페이스 멤버는 항상 열려있어서 final 로 변경 불가능하다.
    * 인터페이스 멤버에게 본문이 없으면 자동으로 추상 멤버가 되지만 그렇더라도 따로 멤버 선언 앞에 abstract 키워드를 덧붙일 필요가 없다.
    *
    * */
}