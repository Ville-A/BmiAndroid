package com.example.bmicalc

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {
    // States for height and weight
    var height by mutableStateOf("")
        private set

    var weight by mutableStateOf("")
        private set

    // Function to update height
    fun updateHeight(newHeight: String) {
        height = newHeight
    }

    // Function to update weight
    fun updateWeight(newWeight: String) {
        weight = newWeight
    }

    // Function to calculate BMI based on current height and weight
    private fun calculateBMI(): Double {
        val heightValue = height.toDoubleOrNull()
        val weightValue = weight.toDoubleOrNull()

        if (heightValue != null && weightValue != null && heightValue > 0) {
            return weightValue / (heightValue * heightValue)
        }
        return 0.0
    }

    // Function to get formatted BMI text
    fun getBMIText(): String {
        val bmi = calculateBMI()
        return if (bmi > 0) {
            String.Companion.format("%.2f", bmi) // Format to 2 decimal places
        } else {
            "Invalid input"
        }
    }
}
