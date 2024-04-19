package training.chapter1

import java.util.Random  //표준 자바 라이브러리 클래스를 임포트
//코틀린에서는 클래스 임포트와 함수 임포트에 차이가 없음


//같은 패키지에 속해있다면 다른 파일에서 정의한 선언일지라도 직접 사용가능
//다른 패키지라면 import 를 통해 불러와야함

class Ractangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {  //프로퍼티 getter 선언
            return height == width
        }
}

fun createRandomRectangle(): Ractangle {
    val random = Random()  //생성자
    return Ractangle(random.nextInt(), random.nextInt())
}
