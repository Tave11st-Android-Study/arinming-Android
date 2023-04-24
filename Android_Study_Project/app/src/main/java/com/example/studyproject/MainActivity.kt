package com.example.studyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {


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

