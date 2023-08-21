package com.example.piggy.feature_expense.presentation.util

sealed class Screen(val route: String){
    object HomeScreen : Screen(route = "home_screen")
    object BudgetScreen : Screen(route = "budget_screen")
    object AddExpenseScreen : Screen(route = "add_expense")
    object CreateExpenseDialog : Screen(route = "create_expense_dialog")
    object TrackScreen : Screen(route = "track_screen")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

