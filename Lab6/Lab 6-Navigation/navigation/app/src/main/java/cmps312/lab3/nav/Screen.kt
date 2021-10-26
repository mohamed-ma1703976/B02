package cmps312.lab3.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route:String, val icon:ImageVector, val title:String){


    object MainScreen:Screen(route = "main_screen", icon= Icons.Outlined.Home, title = "main")
    object DetailScreen:Screen(route = "detail_screen",icon= Icons.Outlined.Star,title = "detail")
    object FundTransferScreen:Screen(route = "fund_transfer_screen",icon= Icons.Outlined.Check,title = "transfer")
    object ConfirmationScreen:Screen(route="confirmation_screen",icon= Icons.Outlined.Home,title = "confirm")



}
