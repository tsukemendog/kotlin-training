package training.chapter3

interface SnsUser {
    val nickname: String
}

interface SnsUser2 {
    val email: String  //email 은 반드시 오버라이드해야한다.
    val nickname: String  //하지만 닉네임은 오버라이드하지 않고 상속 가능하다.
        get() = email.substringBefore("@")  //프로퍼티에 뒷받침(상태저장)하는 필드가 없다. 대신 매번 결과를 계산해 돌려준다.
}

class SnsUser3(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name: "$field" -> "$value".""".trimIndent())
            field = value  //field 는 특별한 식별자이다.
        }
}


class PrivateUser(override val nickname: String) : SnsUser  //주 생성자 안에 프로퍼티를 직접 선언하는 간결한 구문을 사용한다.

class SubscribingUser(val email: String) : SnsUser {
    override val nickname: String
        get() = email.substringBefore("@")  //커스텀 게터로 닉네임 프로퍼티를 설정한다.
}

class FacebookUser(val accountId: Int) : SnsUser {
    override val nickname = "testAccount"
}


class LengthCounter {
    var counter: Int = 0
        private set  //이 클래스 밖에서는 프로퍼티의 값을 바꿀 수 없다.

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
    println("111 : " + PrivateUser("test@naver.com").nickname)
    println("222 : ${SubscribingUser("test@naver.com").nickname}")

    val user3 =SnsUser3("Hello")
    user3.address = "World"
}