package com.example.piggy.feature_expense.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.piggy.feature_expense.domain.repository.ExpenseRepository
import com.example.piggy.feature_expense.domain.use_case.expense_usecase.ExpenseUseCases
import com.example.piggy.feature_expense.presentation.SharedViewModel
import com.example.piggy.feature_expense.presentation.add_expense.AddExpenseScreen
import com.example.piggy.feature_expense.presentation.add_expense.AddExpenseState
import com.example.piggy.feature_expense.presentation.add_expense.AddExpenseViewModel
import com.example.piggy.feature_expense.presentation.add_expense.component.CreateExpenseDialog
import com.example.piggy.feature_expense.presentation.add_expense.component.ExpenseTag
import com.example.piggy.feature_expense.presentation.add_expense.component.expenseTags
import com.example.piggy.feature_expense.presentation.budget_expense.BudgetExpenseScreen
import com.example.piggy.feature_expense.presentation.home_screen.HomeScreen
import com.example.piggy.feature_expense.presentation.track_screen.TrackBudgetScreen
import com.example.piggy.feature_expense.presentation.util.Screen


@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navHostController = navController, sharedViewModel =  SharedViewModel())
        }
        composable(route = Screen.AddExpenseScreen.route){
            AddExpenseScreen(
                state = AddExpenseState(),
                navHostController = navController ,
                sharedViewModel = SharedViewModel(),
                viewModel = AddExpenseViewModel()
            )
        }
        composable(route = Screen.CreateExpenseDialog.route){
            CreateExpenseDialog(state = AddExpenseState(), sharedViewModel = SharedViewModel(), navHostController = navController)
        }
        composable(route = Screen.BudgetScreen.route){
            BudgetExpenseScreen(navController = navController, sharedViewModel = SharedViewModel())
        }
        composable(route = Screen.TrackScreen.route){
            TrackBudgetScreen(navHostController = navController, sharedViewModel = SharedViewModel())
        }

    }
}