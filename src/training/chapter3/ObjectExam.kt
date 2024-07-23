package training.chapter3

import training.chapter3.Person

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


fun main() {
    Payroll.allEmployees.add(Person(name = "moonsu"))
}