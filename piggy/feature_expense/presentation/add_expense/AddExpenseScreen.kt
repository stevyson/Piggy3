package com.example.piggy.feature_expense.presentation.add_expense

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.piggy.feature_expense.presentation.SharedViewModel
import com.example.piggy.feature_expense.presentation.add_expense.component.CreateExpenseDialog
import com.example.piggy.feature_expense.presentation.add_expense.component.ExpenseTag
import com.example.piggy.feature_expense.presentation.add_expense.component.expenseTags
import com.example.piggy.feature_expense.presentation.util.Screen
import com.example.piggy.ui.theme.Zoffany
import com.google.accompanist.flowlayout.FlowRow


@Composable
fun AddExpenseScreen(
    state: AddExpenseState,
    navHostController: NavHostController,
    sharedViewModel: SharedViewModel,
    viewModel: AddExpenseViewModel = androidx.lifecycle.viewmodel.compose.viewModel()

    ){



    if(state.isCreatingExpense) {
        CreateExpenseDialog(
            state = state,
            navHostController = navHostController,
            sharedViewModel = SharedViewModel()
        )
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Zoffany)
                .height(45.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Select Your Expenses", color = Color.Black)
            Spacer(modifier = Modifier.width(80.dp))
            Icon(imageVector = Icons.Default.Done,
                contentDescription = "done",
                modifier = Modifier.clickable {
                    val selectedTags =  expenseTags.filter { it.isSelected }
                    sharedViewModel.addExpense(selectedTags)
                    navHostController.navigate(Screen.BudgetScreen.route)
                }
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ){
            FlowRow(
                mainAxisSpacing = 10.dp,
                crossAxisSpacing = 10.dp,
                modifier = Modifier.fillMaxWidth(),
            ){
                expenseTags.forEach { ExpenseTag ->
                    // Pass the current expenseTag and handle the selection
                    ExpenseTag(
                        expenseTag = ExpenseTag,
                        isSelected = false,
                        onItemClick = {
                            viewModel.OnExpenseTagSelected(it)
                        }
                    )
                }
                // Create custom expense Tags
                Box(
                    modifier = Modifier
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(100.dp)
                        )
                        .padding(10.dp)
                        .clickable {
                            viewModel.ShowDialog()
                        }

                ) {
                    Text(
                        text = "+",
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
        }
}







