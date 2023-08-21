package com.example.piggy.feature_expense.presentation.add_expense

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.piggy.feature_expense.domain.repository.ExpenseRepository
import com.example.piggy.feature_expense.domain.use_case.expense_usecase.ExpenseUseCases
import com.example.piggy.feature_expense.domain.util.UiEvent
import com.example.piggy.feature_expense.presentation.add_expense.component.ExpenseTag
import com.example.piggy.feature_expense.presentation.add_expense.component.expenseTags
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//i am trying to write the viewmodel for a selection screen in  an expense tracker app,
// remember i am using dependency injections,
// the selection screen is a flowrow of list of expense tag items
// and clicking on your expense tag of your choice,
// and clicking okay should take you to another screen,the budget expense screen.
// You should also be able to create a custom expense tag of your choice
// and it will be added to the selection screen.



class AddExpenseViewModel(

): ViewModel() {


    lateinit var expenseTag: ExpenseTag
    // MutableLiveData for the title of the selection screen

    // LiveData for available expense tags
    private val _availableExpenseTags = MutableLiveData<List<ExpenseTag>>(expenseTags)
    val availableExpenseTags: LiveData<List<ExpenseTag>>
        get() = _availableExpenseTags

    private val _state = MutableStateFlow(AddExpenseState())
    val state: MutableStateFlow<AddExpenseState> = _state

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()




    fun OnExpenseTagSelected(expenseTag: ExpenseTag)  {
        viewModelScope.launch {
            if (expenseTag.isSelected){
                expenseTag.isSelected = false
            }
            expenseTag.isSelected = true
        }
    }

    fun ShowDialog(){
        state.update { it.copy(
            isCreatingExpense = true
        )}
    }



    fun SetTitle(){
        state.update { it.copy(
            title = expenseTag.title
        )}
    }

    fun SaveNewExpense(tagName: String) {


            // Create a new expense tag
            val newExpenseTag = ExpenseTag(
                title = tagName,
                price = 0.00,
                isSelected = true
            )

            // Get the current list of expense tags
            val currentTags = _availableExpenseTags.value.orEmpty().toMutableList()

            // Add the new expense tag to the list
            currentTags.add(newExpenseTag)

            // Update the LiveData with the modified list of tags
            _availableExpenseTags.value = currentTags


        }



    fun HideDialog (){
        state.update { it.copy(
            isCreatingExpense = false
        )}
    }


}





