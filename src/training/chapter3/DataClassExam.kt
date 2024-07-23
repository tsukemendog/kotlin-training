package training.chapter3

class Client(val name: String, val postalCode: Int) {
    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"
}



class Client2(val name: String, val postalCode: Int) {
    override fun equals(other: Any?): Boolean {  //Any 는 자바의 Object 에 대응하는 클래스로 코틀린의 모든 클래스의 최상위 클래스이다.
        //Any?는 널이 될 수 있는 타입이므로 other 은 null 일 수 있다.

        if (other == null || other !is Client)   //other 가 client 인지 검사한다
            return false
        //코틀린의 is는 자바의 instanceOf 와 같다
        
        return name == other.name && postalCode == other.postalCode //두 객체의 프로퍼티 값이 서로 같은지 검사한다.
    }

    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"
 
    override fun hashCode(): Int {   //hashCode 도 같이 오버라이드 해주어야 equals 도 잘 동작하고 문제없다  hashCode 는 해시기반 컨테이너에서 동작한다. (HashSet, HashMap)
        return name.hashCode() * 31 + postalCode
    }
}

//data 클래스는 hashCode, toString, equals 등을 자동 생성해준다

data class Client3(val name: String, val postalCode: Int)  //데이터 클래스의 프로퍼티는 왠만하면 val 로 하자.. hashSet 등에 사용할 때 불변성이 요구되기 때문에...

fun main() {
    println("Client : ${Client("잼민", 12)}")

}