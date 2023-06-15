package com.example.master_chef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<Button>(R.id.newRegister).setOnClickListener {
            val registerIntent = Intent(this,LoginActivity::class.java)
            registerIntent.putExtra("newUserName",findViewById<EditText>(R.id.newUserName).text.toString())
            registerIntent.putExtra("newPassword",findViewById<EditText>(R.id.newPassword).text.toString())
            setResult(RESULT_OK,registerIntent)
            finish()
        }
    }
}