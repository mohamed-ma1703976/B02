package cmps312.lab3.lab10

sealed class Screen(val route: String, val title: String) {

    object Home : Screen(route = "Projects", title = "Project List")
    object AddProject : Screen(route = "Add Project", title = "Add Project")
    object TodoHome : Screen(route = "Todo List", title = "Todo List")
    object AddTodo : Screen(route = "Add Todo", title = "Add Todo")


}