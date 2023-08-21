package com.example.piggy.feature_expense.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.piggy.feature_expense.presentation.add_expense.component.ExpenseTag

class SharedViewModel: ViewModel() {

    var expense by  mutableStateOf<List<ExpenseTag?>>(emptyList())
        private set


    fun addExpense(newExpense: List<ExpenseTag>) {
        expense = newExpense
    }
}

