package com.example.weatherapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    // Declare variables for TextViews and Button
    private lateinit var temperatureDetails: TextView
    private lateinit var averageTemperature: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

// Initialize TextViews and Button from layout
        temperatureDetails = findViewById(R.id.temperatureDetails)
        averageTemperature = findViewById(R.id.averageTemperature)
        backButton = findViewById(R.id.backButton)

        // Set the onClick listener for the back button
        backButton.setOnClickListener {
            onBackButtonClicked()
        }
// Display temperature data
        displayTemperatures()
    }

    // Display temperature details on TextViews
    private fun displayTemperatures() {
        val minTemps = TemperatureData.minTemps
        val maxTemps = TemperatureData.maxTemps
        val averageTemp = TemperatureData.averageTemp

        temperatureDetails.text = "Min Temps: $minTemps\nMax Temps: $maxTemps"
        averageTemperature.text = "Average Temp: $averageTemp"
    }

    // Method to handle the back button click
    private fun onBackButtonClicked() {
        finish() // Close the current activity and return to the previous one
    }
}
