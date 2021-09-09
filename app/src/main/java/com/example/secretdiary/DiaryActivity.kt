package com.example.secretdiary

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import androidx.core.widget.addTextChangedListener

class DiaryActivity : AppCompatActivity() {
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)

        val diaryEditText: EditText = findViewById(R.id.diaryEditText)

        /* Bring the MainActivity Information from `MainActivity.kt` SharePreferences */
        val detailPreferences = getSharedPreferences("diary", Context.MODE_PRIVATE)

        diaryEditText.setText(detailPreferences.getString("detail", ""))

        /* Asynchronous Style - Editor */
        val runnable = Runnable {
            getSharedPreferences("diary", Context.MODE_PRIVATE).edit {
                putString("detail", diaryEditText.text.toString())
            }

            Log.d("DiaryActivity", "SAVE!!! ${diaryEditText.text.toString()}")
        }

        /* `UI` part works this section only */
        runOnUiThread{

        }

        /* Original version (When the developer did not use `Main-Looper` */
        handler.post{

        }

        /* This is not a main-thread, because it is not `UI-Thread` part */
        var t = Thread(Runnable{
            // Network task


            Log.e("aa", "aa")
        }).start()

        diaryEditText.addTextChangedListener {
            Log.d("DiaryActivity", "TextChanged :: $it")
            handler.removeCallbacks(runnable) // Delete if there is message callback
            handler.postDelayed(runnable, 500)
        }
    }
}