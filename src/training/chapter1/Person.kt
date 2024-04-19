package training.chapter1

//val로 파라미터를 선언하면 읽기전용 (getter만 선언) var를 선언하면 변경도 가능 (setter 도 추가)
class Person(val name: String, var isMarried: Boolean)  //코틀린의 기본 가시성은 public 이다.