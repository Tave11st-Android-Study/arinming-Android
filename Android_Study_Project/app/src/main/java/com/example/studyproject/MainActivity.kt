package com.example.studyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {


    val TAG = "MainActivity"    // 변하지 않는 값은 val로 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        // if문과 거의 동일하다, when이 더 눈에 잘 들어옴

    }




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

// launch : 코루틴 빌더, 독립적으로 계속 작동하는 나머지 코드와 동시에 새로운 코루틴을 시작
// delay : 특정 시간동안 코루틴을 일시 중단, 기본 스레드를 차단하지는 않고 다른 코루틴이 기본 스레드를 실행할 수 있다
// runBlocking : fun main()에서 코루틴이 있는 코드와 코루틴이 아닌 코드를 연결하는 코루틴 빌더


fun main () = runBlocking {
    launch {    // 새로운 코루틴을 시작하고 계속한다
        delay ( 1000L ) // 1초 지연
        println( "World!" ) // 1초 뒤에 출력
    }
    println("Hello")    // 메인 코루틴은 이전 코루틴이 지연되는 동안 계속된다

    main2()
    doDone()

    // 명시적 작업

    // launch 코루틴 빌더는 실행된 코루틴에 대한 핸들
    // 작업이 완료될 때까지 명시적으로 기다리는 데 사용할 수 있는 job 개체를 반환
    // 자식 코루틴이 완료될 때까지 기다린 후 완료 문자 print

    val job = launch {  // 새 코루틴을 시작하고 작업에 대한 참조를 유지한다
        delay( 1000L )
        println("World~")
    }
    println("Hi!")
    job.join()  // 자식 코루틴이 완료될 때까지 대기
    println("완료")



    // 코루틴은 JVM 스레드보다 자원 집약도가 낮다 -> 가볍다!
    // 스레드를 사용할 때 JVM 가용 메모리를 소진하는 코드는 리소스 제한에 도달하지 않고 코루틴을 사용하여 표현할 수 있다
    // 50,000개의 서로 다른 코루틴을 실행하고 각각 5초를 기다린다 -> 매우 적은 메모리로 마침표를 인쇄
    repeat(50_000) {    // 코루틴 반복
        launch {
            delay(5000L)
            println(".")
        }
    }
    // 5초 뒤에 50,000개의 마침표가 찍힌다
    // 스레드를 활용하여 위의 반복을 작성하면 많은 메모리를 소비한다.
    // 가벼운 코루틴을 쓰자

}

// coroutineScope 빌더를 사용하여 자신의 범위를 선언할 수 있다
// 코루틴 범위를 생성하고 시작된 모든 자식 함수가 완료될 때 까지 끝나지 않는다

// runBlocking과 coroutineScope 빌더는 비슷해 보일 수 있다
// runBlocking 메서드는 대기를 위해 현재 스레드를 차단 : 일반 함수
// coroutineScope는 일시 중단 -> 다른 용도를 위해 기본 스레드를 해제 : 정지 함수



fun main2 () = runBlocking {
    doWorld()
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(100L)
        println("World!")
    }
    println("Hello")
}


// coroutineScope 빌더 : 여러 작업을 동시 수행하기 위해 정지 함수 내에서 사용
// 일시 중단 함수 내에서 두개 코루틴 동시 실행

// 블록 내부의 launch{} 두 코드는 동시에 실행된다
// 1초 후 인쇄 -> 2초 후 인쇄
// coroutineScope는 둘 다 완료된 후에 완료되므로 그 후에만 문자열을 반환한다

fun doDone() = runBlocking {
    doWorld2()
    println("Done")
}



suspend fun doWorld2() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}

