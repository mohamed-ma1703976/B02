package cmps312.lab3.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.math.absoluteValue

@Composable
fun FundTransferScreen(navController: NavController){
    var text1 by remember { mutableStateOf("") }
    var amount by remember {mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var  accnt_num by remember { mutableStateOf("") }
Card(modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxSize(),elevation = 16.dp) {
    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        OutlinedTextField(value = text1 , onValueChange ={text1 =it}  , label = { Text(text = "From Account Number ")})

        OutlinedTextField(value = amount , onValueChange ={amount =it} , label = { Text(text = "Amount ")})
        OutlinedTextField(value = name , onValueChange ={name =it}  , label = { Text(text = "Beneficiary Account Number ")})

        OutlinedTextField(value = accnt_num , onValueChange ={accnt_num =it} , label = { Text(text = "Beneficiary Name ")})

        OutlinedButton(onClick = {navController.navigate("confirmation_screen/$text1/$amount/$name/$accnt_num")  }, modifier = Modifier.align(
            Alignment.CenterHorizontally)) {
            Text(text = "Fund Transfer")
        }
    }
}

}