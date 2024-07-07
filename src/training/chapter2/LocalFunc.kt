package training.chapter2

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can't save user ${user.id}: empty Address")
    }

    // user를 데이터베이스에 저장한다.
}

fun saveUserUsedLocalFunc(user: User) {  //로컬함수를 이용한 검증함수

    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can't save user ${user.id}: empty ${fieldName}")
        }
    }

    validate(user.name, "Name")  //로컬 함수는 자신이 속한 바깥함수의 모든 파라미터와 변수를 사용할 수 있다.
    validate(user.address, "Address")
    // user를 데이터베이스에 저장한다.
}



fun main(args: Array<String>) {
    saveUser(User(1, "", ""))
}