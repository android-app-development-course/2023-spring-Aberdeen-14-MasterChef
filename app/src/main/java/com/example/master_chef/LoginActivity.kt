package com.example.master_chef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private var userNameKey = "Empty"

private var passwordKey = "Empty"


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        findViewById<Button>(R.id.login1).setOnClickListener {
            val userNameForm = findViewById<EditText>(R.id.userName).text.toString()
            val passwordForm = findViewById<EditText>(R.id.password).text.toString()
            if (userNameForm.isNotEmpty() && passwordForm.isNotEmpty()) {
                if(userNameForm == userNameKey && passwordForm == passwordKey){
                    val welcomeIntent = Intent(this, MainActivity2::class.java)
                    startActivity(welcomeIntent)
                }else{
                    val wrongToast = Toast.makeText(this,"账号或密码错误", Toast.LENGTH_LONG)
                    wrongToast.show()
                }
            } else {
                val emptyToast = Toast.makeText(this, "请先注册...", Toast.LENGTH_LONG)
                emptyToast.show()
            }
        }


        findViewById<Button>(R.id.register1).setOnClickListener {
            val toRegisterIntent = Intent(this,RegisterActivity::class.java)
            startActivityForResult(toRegisterIntent,1)
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1 && resultCode == RESULT_OK)
            userNameKey = data?.getStringExtra("newUserName").toString()
            passwordKey = data?.getStringExtra("newPassword").toString()
    }
}