package training.chapter3

import training.chapter3.Person
import java.io.File

object Payroll {  //객체 선언은 클래스 선언과 그 클래스에 속한 단일 인스턴스의 선언을 합친 선언이다
    
    //객체 선언 안에도 프로퍼티, 메소드, 초기화 블록 등이 들어감, 하지만 생성자는 객체 선언에 사용할 수 없음
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {
            TODO("....")
        }
    }
}

data class Person(val name: String) {

    //Comparator 는 클래스 내부에 선언하는게 더 적절하다.
    object NameComparator : Comparator<Person> {
        override fun compare(o1: Person, o2: Person): Int {
            return o1.name.compareTo(o2.name)
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        //TODO("Not yet implemented")
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

class A {
    companion object {  //동반객체는 자바의 정적메소드와 똑같다
        fun bar() {  //이렇듯 정적 메소드는 동반객체 안에서 선언한다.
            println("bar")
        }
    }
}

class CompanionPerson(val name: String) {
    companion object Loader {  //동반객체에 이름을 붙임
        fun fromJSON(jsonText: String) : CompanionPerson {
            TODO()
        }
    }

}

interface JSONFactory<T> {
    fun fromJSON(jsonText: String) : T
}

class CompanionPerson2(val name: String) {
    companion object : JSONFactory<CompanionPerson2> {  //동반객체가 인터페이스를 구현할 수도 있다.
        override fun fromJSON(jsonText: String): CompanionPerson2 {
            TODO("Not yet implemented")
        }
    }
}

fun loadFromJSON (factory: JSONFactory<CompanionPerson2>): CompanionPerson2 {
    TODO()
}


fun main() {
    Payroll.allEmployees.add(Person(name = "moonsu"))
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

    val files = listOf(File("/2"), File("/a"))
    loadFromJSON(CompanionPerson2)  //동반객체가 인터페이스를 구현하고 있으니 인자로 넘길수도 있음
    println(files.sortedWith(CaseInsensitiveFileComparator)) //이런식으로 싱클톤 객체를 활용할 수 있다.
}