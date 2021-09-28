package cmps312.lab3.bankingapplicationmvvm

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import cmps312.lab3.bankingapplicationmvvm.common.getCurrentRoute
import cmps312.lab3.bankingapplicationmvvm.ui.theme.BankingApplicationMVVMTheme
import cmps312.lab3.bankingapplicationmvvm.views.BankingViewModel
import cmps312.lab3.bankingapplicationmvvm.views.MyNavHost


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankingApplicationMVVMTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(this)
                }
            }
        }
    }
}
@Composable
fun MyApp(context: Context) {
    val navHostController = rememberNavController()
    val bankViewModel = BankingViewModel(context)
    Scaffold(
        topBar = { TopBar(navHostController) },
        bottomBar = { BottomBar(navHostController) }
    ) {
        MyNavHost(navHostController, bankViewModel)
    }
}


@Composable
fun TopBar(navHostController: NavHostController) {
    Column {
        Text(text = "Top Bar")
    }
}

@Composable
fun BottomBar(navHostController: NavHostController) {
    var bottomNavItems = listOf(
        Screen.Home,
        Screen.FundTransfer,
        Screen.AccountDetail
    )
    val currentRoute = getCurrentRoute(navHostController)
    BottomNavigation {
        bottomNavItems.forEach { screen ->
            BottomNavigationItem(
                selected = currentRoute == screen.route,
                onClick = { navHostController.navigate(screen.route) },
                icon = { Icon(imageVector = screen.icon, contentDescription = screen.title) },
                label = { Text(text = screen.title) },
                alwaysShowLabel = true
            )
        }
    }

}

