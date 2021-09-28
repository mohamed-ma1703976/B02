package cmps312.lab3.bankingapplicationmvvm.views.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import cmps312.lab3.bankingapplicationmvvm.Screen
import cmps312.lab3.bankingapplicationmvvm.model.Transfer
import cmps312.lab3.bankingapplicationmvvm.views.BankingViewModel

//Todo implement the list of transfers , when the user clicks on a transfer navigate them to the detail screen that shows the complete transfer list
@Composable
fun Home(navHostController: NavHostController, bankingViewModel: BankingViewModel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = 16.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

        }
    }
}

@Composable
fun TransferCar(transfer: Transfer, onTransferSelected: () -> Unit) {
    Card(elevation = 10.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)) {
        Row(modifier = Modifier
            .padding(15.dp)
            .clickable { onTransferSelected() },
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Screen.Beneficiary.icon, contentDescription = "Person Image")
            Column(modifier = Modifier.weight(3f)) {
                Text(text = "From : ${transfer.fromAccountNo}")
                Text(text = "To : ${transfer.beneficiaryName}")
                Text(text = "Amount : ${transfer.amount}")
            }
        }
    }
}