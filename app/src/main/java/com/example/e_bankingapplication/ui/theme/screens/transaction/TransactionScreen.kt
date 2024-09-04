package com.example.e_bankingapplication.ui.theme.screens.transaction


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.e_bankingapplication.data.AccountViewModel
import com.example.e_bankingapplication.models.Transaction
//import com.example.e_bankingapplication.navigation.context


@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TransactionScreen(
    accountId: String,
    userId: String,
    viewModel: AccountViewModel 
) {
    val account = viewModel.accounts.value.find { it.id == accountId }

    Column(modifier = Modifier.padding(16.dp)) {
        account?.let {
            Text(text = "Account Number: ${it.accountNumber}")
            Text(text = "Current Balance: $${it.balance}")

            Button(
                onClick = {
                    val initialBalance = it.balance
                    val transactionAmount = 100.0
                    val finalBalance = initialBalance - transactionAmount
                    val transaction = Transaction(
                        id = "trans_id_1",
                        accountId = it.id,
                        type = "Withdraw",
                        amount = transactionAmount,
                        initialBalance = initialBalance,
                        finalBalance = finalBalance,
                        timestamp = System.currentTimeMillis(),
                        userName = "",
                        userNationalId = ""
                    )

                    viewModel.createTransaction(transaction)
                    viewModel.updateAccount(it.copy(balance = finalBalance))
                })
            {

            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun TransactionPreview(){
    val navController = rememberNavController()
    val context = LocalContext.current
    TransactionScreen(accountId = "", userId = "", viewModel = AccountViewModel(navController, context) )
}




