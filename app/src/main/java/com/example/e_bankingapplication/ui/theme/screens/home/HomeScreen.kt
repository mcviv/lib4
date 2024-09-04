package com.example.e_bankingapplication.ui.theme.screens.home

import androidx.compose.material3.Scaffold
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.e_bankingapplication.compose.AccountCard
import com.example.e_bankingapplication.data.AccountViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val viewModel = AccountViewModel(navController, context)
    val accounts = viewModel.accounts.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("E-Banking App") })
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(accounts.value.size) { index ->
                    val account = accounts.value[index]
                    AccountCard(account = account) {
                        navController.navigate("accountDetails/${account.id}")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("airtime") }) {
                Text("Buy Airtime")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate("loanRequest") }) {
                Text("Request Loan")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}
