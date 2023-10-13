package com.example.netquest_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.netquest_2.MainActivity
import com.example.netquest_2.R
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance()

        val usernameEditText = findViewById<EditText>(R.id.editText_username)
        val passwordEditText = findViewById<EditText>(R.id.editText_password)
        val registerButton = findViewById<Button>(R.id.button_register)
        val loginTextView = findViewById<TextView>(R.id.textView_login)

        registerButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            // Bypass the registration process
            if (username == "test" && password == "test") {
                Toast.makeText(baseContext, "Registration Bypassed.", Toast.LENGTH_SHORT).show()
                // Navigate to the next activity or main app screen here
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
                return@setOnClickListener
            } // Bypass the registration process
            if (validateForm(username, password)) {
                createAccount(username, password)
            }
        }

        loginTextView.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }

    private fun validateForm(username: String, password: String): Boolean {
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(baseContext, "Fields cannot be empty.", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(baseContext, "Registration Successful.", Toast.LENGTH_SHORT).show()
                    // navigate to the next activity or main app screen here
                } else {
                    Toast.makeText(baseContext, "Authentication Failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
