package com.example.e_bankingapplication.repository

import android.accounts.Account
import com.example.e_bankingapplication.models.Transaction
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await


class AccountRepository {
    inner class AccountRepository(userId: String, override val size: Int) : List<Account> {
        override fun contains(element: Account): Boolean {
            TODO("Not yet implemented")
        }

        override fun containsAll(elements: Collection<Account>): Boolean {
            TODO("Not yet implemented")
        }

        override fun get(index: Int): Account {
            TODO("Not yet implemented")
        }

        override fun isEmpty(): Boolean {
            TODO("Not yet implemented")
        }

        override fun iterator(): Iterator<Account> {
            TODO("Not yet implemented")
        }

        override fun listIterator(): ListIterator<Account> {
            TODO("Not yet implemented")
        }

        override fun listIterator(index: Int): ListIterator<Account> {
            TODO("Not yet implemented")
        }

        override fun subList(fromIndex: Int, toIndex: Int): List<Account> {
            TODO("Not yet implemented")
        }

        override fun lastIndexOf(element: Account): Int {
            TODO("Not yet implemented")
        }

        override fun indexOf(element: Account): Int {
            TODO("Not yet implemented")
        }

    }

    private val db = FirebaseFirestore.getInstance()

    suspend fun getAccounts(userId: String): List<Account> {
        return db.collection("accounts")
            .whereEqualTo("userId", userId)
            .get()
            .await()
            .toObjects(Account::class.java)
    }

    suspend fun updateAccount(account: com.example.e_bankingapplication.models.Account) {
        db.collection("accounts").document(account.id).set(account).await()
    }

    suspend fun deleteAccount(accountId: String) {
        db.collection("accounts").document(accountId).delete().await()
    }

    suspend fun createTransaction(transaction: Transaction) {
        db.collection("transactions").add(transaction).await()
    }
    suspend fun purchaseAirtime(phoneNumber: String, amount: Int, onResult: (Boolean, String?) -> Unit){
        db.collection("airtime").add(amount).await()
    }

    fun purchaseAirtime(phoneNumber: String, amount: Int) {
        TODO("Not yet implemented")
    }

    fun AccountRepository(userId: String): AccountRepository {
        TODO("Not yet implemented")
    }
}
