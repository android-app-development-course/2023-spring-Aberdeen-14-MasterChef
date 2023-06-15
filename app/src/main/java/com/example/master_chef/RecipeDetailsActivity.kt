package com.example.master_chef

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailsActivity : AppCompatActivity() {
    private lateinit var recipeNameTextView: TextView
    private lateinit var methodTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        recipeNameTextView = findViewById(R.id.recipeNameTextView)
        methodTextView = findViewById(R.id.methodTextView)
        backButton = findViewById(R.id.backButton)

        val recipeName = intent.getStringExtra("recipeName")
        val method = intent.getStringExtra("method")

        recipeNameTextView.text = recipeName
        methodTextView.text = method

        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        // 应用页面切换动画
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

}



