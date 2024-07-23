package training.chapter3

//주생성자는 바깥에서 정의 부생성자는 본문안에서 정의

class User1(val nickName: String)  //괄호로 둘러쌓인 코드를 주생성자라고 한다.
//파라미터 이름앞에 val를 추가하는 방식으로 프로퍼티 정의와 초기화를 간략히 쓸 수 있다.
//val 는 이 파라미터에 상응하는 프로퍼티가 생성된다는 뜻이다.

class User2(_nickname : String) {  //파라미터가 하나뿐인 주 생성자
    val nickname = _nickname  //프로퍼티를 주 생성자의 파라미터로 초기화한다.
}


class User3 constructor(_nickname: String) {  // constructor 키워드는 주생성자나 부생성자 정의를 시작할 때 사용한다.
    //_nickname 에서 맨 앞의 밑줄은 프로퍼티와 생성자 파라미터를 구분해준다.
    //주생성자 앞에 별다른 가시성 변경자가 없다면 constructor 를 생략해도 된다.


    val nickName: String
    init {  //초기화 블록
        nickName = _nickname
    }
}



// 위 세가지 방식은 다 같지만 결국 User1 방식이 제일 간단명료하고 좋다.

//함수 파라미터와 마찬가지로 생성자 파라미터에도 디폴트 값을 정의할 수 있다.
open class User4(val nickname : String, val isSubscribed: Boolean = true)

class ChildUser(nickname : String, isSubscribed: Boolean = true) : User4(nickname, isSubscribed)


class Secrettive private constructor() {}  // private 변경자를 통해 외부에서 인스턴스화 하지 못하게 막는다


open class SubConstruct {

    constructor(name: String) {  //부생성자는 클래스 본문안에 constuctor 키워드를 사용하여 정의한다

    }

    constructor(name: String, age: Int) {

    }
}

class SubConstructChild : SubConstruct {
    constructor(name: String) : super(name){  //상위 클래스의 생성자를 호출한다.
        println(name)
    }
    
    constructor(name: String, age: Int) : super(name, age) {
        
    }
}

//클래스에 주생성자가 없으면 반드시 부생성자를 통해 상위클래스를 초기화하거나 다른 생성자에게 생성을 위임해야 한다.
class SubConstructChild2 : SubConstruct {
    constructor(name: String) : this(name, 23){  //this 를 통해 다른 생성자에게 생성을 위임 할수도 있다.

    }

    constructor(name: String, age: Int) : super(name, age) {

    }
}


fun main() {
    val moonsu = User4("moonsu")  //new 키워드 없이 그냥 생성자를 직접 호출하면 된다.
    println("my name is ${moonsu.nickname}")

    val james = User4("james", false)
    println("james ${james.isSubscribed}")

    val paul = User4("paul", isSubscribed = false) //인자 중 일부에 대해 이름을 지정할 수도 있다.
    println("paul ${paul.isSubscribed}")
}