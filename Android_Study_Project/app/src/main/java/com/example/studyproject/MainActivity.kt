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

    doDone()
}


// coroutineScope 빌더 : 여러 작업을 동시 수행하기 위해 정지 함수 내에서 사용
// 일시 중단 함수 내에서 두개 코루틴 동시 실행

fun doDone() = runBlocking {
    doWorld()
    println("Done")
}



suspend fun doWorld() = coroutineScope {
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

