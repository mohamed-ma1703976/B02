package cmps312.lab3.nav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch

@Composable




fun MainScreen(navController: NavController){
    var text by remember {mutableStateOf("") }
    var age by remember {
        mutableStateOf("")
    }
Card(modifier = Modifier.padding(16.dp).fillMaxWidth().fillMaxSize(),elevation = 16.dp){Column(modifier = Modifier
    .padding(16.dp)
    .fillMaxWidth().fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally,

    ) {
    Text(text="Welcome!")
    Text(text="Thank you for banking with us!")


    OutlinedButton(onClick = { navController.navigate("fund_transfer_screen") }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Text(text = "Fund Transfer")

    }
    OutlinedButton(onClick = { navController.navigate("detail_screen") }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Text(text = "Check Balance!")
}}}}


