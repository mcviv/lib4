package com.example.e_bankingapplication.data



import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.e_bankingapplication.models.Account
import com.example.e_bankingapplication.models.Transaction
import com.example.e_bankingapplication.repository.AccountRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AccountViewModel(navController: NavController, context: Context) : ViewModel() {

    private val repository = AccountRepository()

    private val _accounts = MutableStateFlow<List<Account>>(emptyList())
    val accounts: StateFlow<List<Account>> get() = _accounts

    fun loadAccounts(
        userId: String,
        trim: String,
        trim1: String,
        trim2: String,
        toString: String,
        trim3: String
    ) {
//        viewModelScope.launch {
//            _accounts.value = repository.AccountRepository(userId)
//        }
    }

    fun updateAccount(account: Account) {
        viewModelScope.launch {
            repository.updateAccount(account)
            val id = String
            val userId = String
            val accountNumber = String
            val balance = String
            val accountType = String
            loadAccounts(account.userId, id.toString(), userId.toString(),
                accountNumber.toString(), balance.toString(), accountType.toString())
        }
    }

    fun deleteAccount(accountId: String, userId: String) {
        viewModelScope.launch {
            repository.deleteAccount(accountId)
            val account = String
            val id = String
            val accountNumber = String
            val balance = String
            val accountType = String
            loadAccounts(account.toString(), id.toString(), userId.toString(),
                accountNumber.toString(), balance.toString(), accountType.toString())
        }
    }

    fun createTransaction(transaction: Transaction) {
        viewModelScope.launch {
            repository.createTransaction(transaction)
        }
    }
    fun purchaseAirtime(phoneNumber: String, amount: Int, onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            try {
                repository.purchaseAirtime(phoneNumber, amount)
                onResult(true, null)
            } catch (e: Exception) {
                onResult(false, e.message)
            }
        }
    }

}
