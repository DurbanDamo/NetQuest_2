package com.example.netquest_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity

class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize views
        val editTextMaxDistance: EditText = findViewById(R.id.editText_max_distance)
        val radioGroupMeasurementSystem: RadioGroup = findViewById(R.id.radioGroup_measurement_system)
        val editTextGeneralInput: EditText = findViewById(R.id.editText_general_input)
        val buttonSave: Button = findViewById(R.id.button_save)

        buttonSave.setOnClickListener {
            // Capture user input
            @Suppress("UNUSED_VARIABLE")
            val maxDistance = editTextMaxDistance.text.toString().toDoubleOrNull()
            @Suppress("UNUSED_VARIABLE")
            val measurementSystem = findViewById<RadioButton>(radioGroupMeasurementSystem.checkedRadioButtonId).text.toString()
            @Suppress("UNUSED_VARIABLE")
            val generalInput = editTextGeneralInput.text.toString()

            // TODO: Save these preferences to shared preferences or database

            // Redirect to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
