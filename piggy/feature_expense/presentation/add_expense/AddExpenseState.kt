package com.example.piggy.feature_expense.presentation.add_expense
import com.example.piggy.feature_expense.presentation.add_expense.component.ExpenseTag


data class AddExpenseState(

    var expenseTags: List<ExpenseTag> = listOf(
        ExpenseTag("Groceries", 0.0 ,false),
        ExpenseTag("Transportation", 0.0 ,false),
        ExpenseTag("Rent", 0.0 ,false),
        ExpenseTag("Utilities", 0.0 ,false),
        ExpenseTag("Dining Out", 0.0 ,false),
        ExpenseTag("Entertainment", 0.0 ,false),
        ExpenseTag("Healthcare", 0.0 ,false),
        ExpenseTag("Clothing", 0.0 ,false),
        ExpenseTag("Phone Bill", 0.0 ,false),
        ExpenseTag("Internet", 0.0 ,false),
        ExpenseTag("Gym Membership", 0.0 ,false),
        ExpenseTag("Coffee", 0.0 ,false),
        ExpenseTag("Snacks", 0.0 ,false),
        ExpenseTag("Gifts", 0.0 ,false),
        ExpenseTag("Movies", 0.0 ,false),
        ExpenseTag("Public Transport", 0.0 ,false),
        ExpenseTag("Books", 0.0 ,false),
        ExpenseTag("Subscriptions", 0.0 ,false),
        ExpenseTag("Travel", 0.0 ,false),
        ExpenseTag("Home Supplies", 0.0 ,false),
        ExpenseTag("Pet Expenses", 0.0 ,false),
        ExpenseTag("Car Maintenance", 0.0 ,false),
        ExpenseTag("Insurance", 0.0 ,false),
        ExpenseTag("Charity", 0.0 ,false),
        ExpenseTag("Kids' Activities", 0.0 ,false),
        ExpenseTag("Personal Care", 0.0 ,false),
        ExpenseTag("House Cleaning", 0.0 ,false),
        ExpenseTag("Tuition", 0.0 ,false),
        ExpenseTag("Miscellaneous", 0.0 ,false)
    ),
    val isCreatingExpense: Boolean = false,
    val title: String = ""
)
