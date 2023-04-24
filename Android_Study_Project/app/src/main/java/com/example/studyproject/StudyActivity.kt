package com.example.studyproject

import android.os.Bundle
import android.util.Log

fun main () {
    val TAG = "MainActivity"    // 변하지 않는 값은 val로 선언


    var myName = "김아린"
    Log.d(TAG, "my name = $myName")
    myName = "아린"   // var는 선언한 뒤 값을 변경할 수 있다
    Log.d(TAG, "my name = $myName")

    val PI = 3.141592   // val은 선언한 뒤 값을 변경할 수 없다
    // 변하지 않는 상수를 정의할 때 사용
    // val 변수는 대문자로 정의하는 것이 개발자들의 약속
    Log.d(TAG, "pi= $PI")


    var myNumber = "1,2,3,4,5,6"
    var thisWeekNumbers = "5,6,7,8,9,10"
    if (myNumber == thisWeekNumbers) {
        Log.d(TAG, "당첨되었습니다")
    } else {
        Log.d(TAG, "당첨되지 않았습니다")
    }

    for (index in 1..10) {    // 1..10 => 1부터 10까지 반복, 키워드를 변수명으로 쓰지 말기
        Log.d(TAG, "현재 숫자는 ${index}입니다") // 문자열 표시에 $ 표시 쓸 때는 한 칸 띄어쓰기
        // $ 표시를 띄어쓰지 않고 표기하려면 변수명에 {}
    }


    var variable = "홍길동"    // 문자열이 들어온 것을 보고 String 변수임을 판단
    // var variable: String = "김아린"  과 같음
    // 타입을 붙여서 코딩하는 것을 권장

    var variable2: String
    variable2 = "김아린"

    // 타입이 한 번 지정되면 타입을 변경할 수 없음, 같은 타입의 다른 값은 넣을 수 있다
    variable = "안녕하세요"


    var helloWorld = "안녕 세상아!"  // 카멜 표기법
    var hello_world = "안녕 세상아!" // 스네이크 표기법


    var first = 300
    var second = 500
    var third = 270

    // 비교연산자 <, >, >=, <=, ==, !=
    var result1 = first < 500
    Log.d("compare", "첫 번째 결과 = ${result1}")
    var result2 = second < 500
    Log.d("compare", "두 번째 결과 = ${result2}")

    // 논리연산자 : 비교연산자의 결과를 다시 한 번 연산
    // && : AND 연산자
    var logic1 = result1 && result2
    Log.d("compare", "논리연산 && 결과 = ${logic1}")
    // || : OR 연산자
    var logic2 = result1 || result2
    Log.d("compare", "논리연산 || 결과 = ${logic2}")
    // 부정연산자 : 단항 연산자 !
    var logic3 = !result1
    Log.d("compare", "논리연산 ! 결과 = ${logic3}")


    // if

    var out = 0
    var strike = 2
    if (strike > 2) {   // strike가 2보다 크면 out 증가
        out = out +1
    }
    Log.d("if", "결과 out = ${out}")


    var month = 10
    if (month > 9) {
        process1()
    } else if(month in 7..8) {
        process2()
    } else {
        process3()
    }


    // when : 다른 언어에서 switch
    // 코틀린 when : if문의 확장판
    when(month) {
        9 -> {  // month 값이 9월일 때 실행
            process1()
        }
        10 -> Log.d("when", "10월입니다.")  // 실행할 내용이 한 줄이면 코드블럭 생략 가능
        1, 2, 3 -> {    // 여러 경우 지정 가능
            process3()
        }
        in 6..8 -> { // 값을 특정하지 않고 범위를 지정할 때
            process2()
        }
        else -> {   // else도 쓸 수 있다
            Log.d("when", "잘못 입력했습니다.")
        }
    }
    // if문과 거의 동일하다, when이 더 눈에 잘 들어옴 }

}


fun process1() {
    Log.d("if", "가을 옷을 입습니다.")
}
fun process2() {
    Log.d("if", "해수욕장을 갑니다.")
}
fun process3() {
    Log.d("if", "집에 있습니다.")
}
