package com.example.studyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


}
fun main () = runBlocking {
    launch {    // 새로운 코루틴을 시작하고 계속한다
        delay ( 1000L ) // 1초 지연
        println( "World!" ) // 1초 뒤에 출력
    }
    println("Hello")    // 메인 코루틴은 이전 코루틴이 지연되는 동안 계속된다
}


