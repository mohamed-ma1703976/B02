package cmps312.lab3.bankingapplicationmvvm.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import cmps312.lab3.bankingapplicationmvvm.Screen
import cmps312.lab3.bankingapplicationmvvm.views.detail.AccountDetails
import cmps312.lab3.bankingapplicationmvvm.views.detail.TransferDetails
import cmps312.lab3.bankingapplicationmvvm.views.fundtransfer.Beneficiary
import cmps312.lab3.bankingapplicationmvvm.views.fundtransfer.FundTransfer
import cmps312.lab3.bankingapplicationmvvm.views.fundtransfer.TransferConfirmation
import cmps312.lab3.bankingapplicationmvvm.views.home.Home

@Composable
fun MyNavHost(navHostController: NavHostController, bankViewModel: BankingViewModel) {
    NavHost(navController = navHostController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) { Home(navHostController ,bankViewModel) }
        composable(route = Screen.AccountDetail.route) { AccountDetails(navHostController) }
        composable(route = Screen.FundTransfer.route) { FundTransfer(navHostController, bankViewModel) }
        composable(route = Screen.Beneficiary.route) { Beneficiary(navHostController, bankViewModel) }
        composable(route = Screen.Confirmation.route) { TransferConfirmation(navHostController, bankViewModel) }
        composable(route = Screen.TransferDetails.route) { TransferDetails(navHostController, bankViewModel) }
    }
}