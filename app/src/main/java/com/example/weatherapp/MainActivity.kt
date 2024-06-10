package com.example.weatherapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare EditTexts for min and max temperatures for each day of the week
    private lateinit var minTempMonday: EditText
    private lateinit var maxTempMonday: EditText
    private lateinit var minTempTuesday: EditText
    private lateinit var maxTempTuesday: EditText
    private lateinit var minTempWednesday: EditText
    private lateinit var maxTempWednesday: EditText
    private lateinit var minTempThursday: EditText
    private lateinit var maxTempThursday: EditText
    private lateinit var minTempFriday: EditText
    private lateinit var maxTempFriday: EditText
    private lateinit var minTempSaturday: EditText
    private lateinit var maxTempSaturday: EditText
    private lateinit var minTempSunday: EditText
    private lateinit var maxTempSunday: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize EditTexts from layout
        minTempMonday = findViewById(R.id.minTempMonday)
        maxTempMonday = findViewById(R.id.maxTempMonday)
        minTempTuesday = findViewById(R.id.minTempTuesday)
        maxTempTuesday = findViewById(R.id.maxTempTuesday)
        minTempWednesday = findViewById(R.id.minTempWednesday)
        maxTempWednesday = findViewById(R.id.maxTempWednesday)
        minTempThursday = findViewById(R.id.minTempThursday)
        maxTempThursday = findViewById(R.id.maxTempThursday)
        minTempFriday = findViewById(R.id.minTempFriday)
        maxTempFriday = findViewById(R.id.maxTempFriday)
        minTempSaturday = findViewById(R.id.minTempSaturday)
        maxTempSaturday = findViewById(R.id.maxTempSaturday)
        minTempSunday = findViewById(R.id.minTempSunday)
        maxTempSunday = findViewById(R.id.maxTempSunday)

        // Initialize buttons from layout
        val addButton: Button = findViewById(R.id.addButton)
        val clearButton: Button = findViewById(R.id.clearButton)
        val viewDetailsButton: Button = findViewById(R.id.viewDetailsButton)

        // Set onClick listeners for buttons
        addButton.setOnClickListener {
            addTemperatures()
        }

        clearButton.setOnClickListener {
            clearTemperatures()
        }

        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }

    // Method to add temperatures to TemperatureData singleton
    private fun addTemperatures() {
        // Initialize lists to store min and max temperatures
        val minTemps = mutableListOf<Double>()
        val maxTemps = mutableListOf<Double>()

        // Add min and max temperatures for each day to the lists
        minTemps.add(minTempMonday.text.toString().toDoubleOrNull() ?: 0.0)
        maxTemps.add(maxTempMonday.text.toString().toDoubleOrNull() ?: 0.0)
        // Repeat for other days...

        // Calculate average temperature
        val allTemps = minTemps + maxTemps
        val averageTemp = allTemps.average()

        // Update TemperatureData singleton with new data
        TemperatureData.minTemps = minTemps
        TemperatureData.maxTemps = maxTemps
        TemperatureData.averageTemp = averageTemp
    }

    // Method to clear temperature input fields
    private fun clearTemperatures() {
        minTempMonday.text.clear()
        maxTempMonday.text.clear()
        // Repeat for other days...
    }
}

// Singleton class to store temperature data
class TemperatureData {
    companion object {
        var averageTemp: Double = 0.0
        lateinit var maxTemps: MutableList<Double>
        lateinit var minTemps: MutableList<Double>
    }
}
