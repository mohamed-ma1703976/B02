package cmps312.lab3.nav

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable

fun ConfirmationScreen(account_number:String?,amount:String?,name:String?,account_num_ben:String?) {

    val context = LocalContext.current
    Card(modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxSize(),elevation = 16.dp) {
        Column(modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,



        ) {
            Text(text = "Account Number : $account_number")
            Text(text = "Amount Transferred:$amount QR")
            Text(text = "Beneficiary Account Number: $name")
            Text(text = "Beneficiary name: $account_num_ben")
            Button(
                onClick = { Toast.makeText(context, "Transferred Sucessfuly", Toast.LENGTH_SHORT).show() },
                modifier = Modifier.align(
                    Alignment.CenterHorizontally
                )
            ) {
                Text(text = "Confirm")
            }
        }


    }
}