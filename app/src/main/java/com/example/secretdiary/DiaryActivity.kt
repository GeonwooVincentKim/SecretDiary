package com.example.secretdiary

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DiaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val diaryEditText: EditText = findViewById(R.id.diaryEditText)

        /* Bring the MainActivity Information from `MainActivity.kt` SharePreferences */
        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)

    }
}