package com.example.secretdiary

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DiaryActivity : AppCompatActivity() {
    private val diaryEditText: EditText by lazy{
        findViewById<EditText>(R.id.diaryEditText)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        /* Bring the MainActivity Information from `MainActivity.kt` SharePreferences */
        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)

    }
}