package com.example.bmicalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.* // For layout elements
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material.*             // For Text, TextField, Scaffold, TopAppBar, etc.


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMICalculatorApp()
        }
    }
}

@Composable
fun BMIContent(viewModel: BMIViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Body mass index",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF9C27B0)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // State fields bound to the ViewModel
        TextField(
            value = viewModel.height,
            onValueChange = { viewModel.updateHeight(it) }, // Use ViewModel to handle updates
            label = { Text("Height (m)") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color(0xFF9C27B0),
                focusedLabelColor = Color(0xFF9C27B0)
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = viewModel.weight,
            onValueChange = { viewModel.updateWeight(it) }, // Use ViewModel to handle updates
            label = { Text("Weight (kg)") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color(0xFF9C27B0),
                focusedLabelColor = Color(0xFF9C27B0)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Dynamically displaying BMI from ViewModel
        Text(
            text = "Body mass index is ${viewModel.getBMIText()}",
            fontSize = 18.sp,
            color = Color(0xFF9C27B0)
        )
    }
}

@Composable
fun BMICalculatorApp(viewModel: BMIViewModel = viewModel()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Body mass index") },
                backgroundColor = Color(0xFF9C27B0),
                contentColor = Color.White
            )
        }
    ) {
        BMIContent(viewModel)
    }
}
