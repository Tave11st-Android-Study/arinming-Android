package com.example.studyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sun.rmi.runtime.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}





// 안드로이드 시스템은 메모리 이외 다른 곳에서 데이터를 가져오는 작업을
// 백그라운드 스레드에서 처리하도록 권장한다

// 백그라운드 스레드를 생성하는 방법


// 1. Thread 객체를 통해 생성하는 경우

class WorkerThread: Thread() {
    override fun run() {
        var i = 0
        while (i < 10) {
            i += 1
            Log.i("WorkerThread", "$i")
        }
    }

}