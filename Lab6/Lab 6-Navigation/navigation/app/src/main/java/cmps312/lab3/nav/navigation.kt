package cmps312.lab3.nav

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import kotlinx.coroutines.launch

@Composable
fun Main(){
    val scaffoldState = rememberScaffoldState()

    //Create a coroutine scope. Opening of Drawer and snackbar should happen in background thread without blocking main thread
    val coroutineScope = rememberCoroutineScope()

    //remember navController so it does not get recreated on recomposition
    val navController = rememberNavController()
    Scaffold(
        //pass the scaffold state
        scaffoldState = scaffoldState,

        bottomBar = { BottomNavigation {
            //observe the backstack
            //val navBackStackEntry by navController.currentBackStackEntryAsState()

            //observe current route to change the icon color,label color when navigated
            //  val currentRoute = navBackStackEntry?.destination?.route
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val navItems = listOf(Screen.MainScreen, Screen.FundTransferScreen, Screen.DetailScreen)

            //Bottom nav items we declared
            navItems.forEach { navItem ->
                BottomNavigationItem(
                    //it currentRoute is equal then its selected route
                    selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                    onClick = {
                        navController.navigate(navItem.route)
                    },
                    icon = {
                        Icon(imageVector = navItem.icon, contentDescription = navItem.title)
                    },
                    label = {
                        Text(text = navItem.title)
                    },
                    alwaysShowLabel = false
                )
            }
        } },

    ) {
        //MainScreen()
            paddingValues -> Navigation(navController = navController, padding = paddingValues)
    }
}




@Composable
fun Navigation(navController: NavHostController,
               padding: PaddingValues){

    val navController = rememberNavController()


    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route) {
            DetailScreen()}
        composable(route = Screen.FundTransferScreen.route) {
            FundTransferScreen(navController = navController)

        }
        composable(route = Screen.ConfirmationScreen.route + "/{account_number}/{amount}/{name}/{account_num_ben}",

            arguments = listOf(navArgument("account_number") {

                type = NavType.StringType

                nullable = true
            },
                navArgument("amount") {

                    type = NavType.StringType

                },
                navArgument("name") {

                    type = NavType.StringType

                    nullable = true
                },
                navArgument("account_num_ben") {

                    type = NavType.StringType

                    nullable = true
                }

                )
        ) { entry -> ConfirmationScreen(account_number = entry.arguments?.getString("account_number"),
            amount = entry.arguments?.getString("amount"),
            name = entry.arguments?.getString("name"),
            account_num_ben = entry.arguments?.getString("account_num_ben")


            ) }


    }}










