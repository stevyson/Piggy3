package com.example.piggy.feature_expense.presentation.track_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.piggy.feature_expense.presentation.SharedViewModel
import com.example.piggy.feature_expense.presentation.track_screen.components.BudgetMeter
import com.example.piggy.feature_expense.presentation.track_screen.components.TrackedExpense


@Composable
fun TrackBudgetScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
) {
   val totalBudget = 200f
    val  totalSpent = 100f

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        BudgetMeter(
            totalSpent = 200f,
            totalBudget = 400f,
            number = 100
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
           modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(text = "$ 75000 remaining")

        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(1.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    TrackedExpense(title ="goat" , price = "1600")
                    TrackedExpense(title = "meat", price = "1220")

                }
                Spacer(modifier = Modifier.height(120.dp))
                Text(text = " $ 11000 spent")
            }
        }




    }

}



