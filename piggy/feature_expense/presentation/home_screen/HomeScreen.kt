package com.example.piggy.feature_expense.presentation.home_screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.piggy.feature_expense.presentation.SharedViewModel
import com.example.piggy.feature_expense.presentation.home_screen.component.BudgetMeter
import com.example.piggy.feature_expense.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel
    ){
    Scaffold(
        topBar = {
            TopAppBar(
                title ={ Text(text = "Budget")}
            )
        },
        content = { padding ->

            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(15.dp).padding(1.dp))

                BudgetMeter(totalSpent = 200f, totalBudget = 400f, number = 100)
                Spacer(modifier = Modifier.height(6.dp))
                //put the remain budget here
                Text(text = "${10067} Remaining")
                Spacer(modifier = Modifier.height(6.dp))
                //put the largest expense here
                Text(text = "Largest Expense: ${"fuel: 1007"}")
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Track Your Spending", Modifier.clickable(onClick = {
                    navHostController.navigate(Screen.TrackScreen.route)
                }))
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Add expense", Modifier.clickable(onClick = {
                    navHostController.navigate(Screen.AddExpenseScreen.route)
                }))
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Update Your Spending", Modifier.clickable(onClick = {
                    navHostController.navigate(Screen.BudgetScreen.route)
                }))
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Financial Tips",Modifier.clickable(onClick = {

                }))
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "Monthly Spending Report", Modifier.clickable(onClick = {

                }))



            }




    })
}