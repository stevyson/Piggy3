package com.example.piggy.feature_expense.presentation.add_expense.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.piggy.feature_expense.domain.util.UiEvent
import com.example.piggy.feature_expense.presentation.SharedViewModel
import com.example.piggy.feature_expense.presentation.add_expense.AddExpenseState
import com.example.piggy.feature_expense.presentation.add_expense.AddExpenseViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateExpenseDialog(
    navHostController: NavHostController,
    state: AddExpenseState,
    modifier: Modifier = Modifier,
    viewModel: AddExpenseViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            viewModel.HideDialog()
        },
        title = { Text(text = "Add Expense")},
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = state.title,
                    onValueChange = {
                        viewModel.SetTitle()
                    },
                    placeholder = {
                        Text(text = "Title")
                    })
            }
        },
        confirmButton = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    UiEvent.PopBackStack
                    viewModel.SaveNewExpense(state.title)
                }) {
                    Text(text = "save")
                }
            }
        }
    )
}