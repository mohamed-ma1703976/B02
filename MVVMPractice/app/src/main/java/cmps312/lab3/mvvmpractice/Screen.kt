package cmps312.lab3.mvvmpractice

sealed class Screen(val route:String){

    object Home:Screen(route = "home")
    object Add:Screen(route = "add")

}
