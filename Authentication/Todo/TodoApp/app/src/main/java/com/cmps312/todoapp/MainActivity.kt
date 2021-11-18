package com.cmps312.todoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cmps312.todoapp.component.GoogleSignInButton
import com.cmps312.todoapp.ui.theme.Lab11Theme
import com.cmps312.todoapp.utils.AuthResult
import com.cmps312.todoapp.viewmodel.SignInViewModel
import com.cmps312.todoapp.viewmodel.TodoViewModel
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val signInViewModel: SignInViewModel by viewModels()
    private val todoViewModel: TodoViewModel by viewModels()
    private val loggedIn = mutableStateOf<Boolean>(false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Firebase.auth.addAuthStateListener {
            if (it.currentUser?.uid == null) {
                loggedIn.value = false
            } else {
                loggedIn.value = true
                val displayName = Firebase.auth.currentUser?.displayName ?: ""
                val message = if (it.currentUser != null)
                    "Welcome $displayName"
                else
                    "Sign out successful"
            }
        }

        setContent {
            Lab11Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    if (loggedIn.value)
                        MainScreen()
                    else
                        SignInScreen(signInViewModel)
                }
            }
        }
    }
}

@Composable
fun SignInScreen(signInViewModel: SignInViewModel) {
    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf<String?>(null) }
    val user by remember(signInViewModel) { signInViewModel.user }.collectAsState()
    val signInRequestCode = 1

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = AuthResult()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account == null) {
                    text = "Google Sign In Failed"
                } else {
                    scope.launch {
                        signInViewModel.setSignInValue(
                            email = account.email!!,
                            displayName = account.displayName!!
                        )
                    }
                }
            } catch (e: ApiException) {
                text = e.localizedMessage
            }
        }

    AuthView(
        errorText = text,
        onClick = {
            text = null
            authResultLauncher.launch(signInRequestCode)
        }
    )

    user?.let {
        MainScreen()
    }
}

@Composable
fun AuthView(
    errorText: String?,
    onClick: () -> Unit,
) {
    var isLoading by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Google Sign In",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            GoogleSignInButton(
                text = "Sign In with Google",
                icon = painterResource(id = R.drawable.btn_google_light),
                loadingText = "Signing In...",
                isLoading = isLoading,
                onClick = {
                    isLoading = true
                    onClick()
                }
            )

            errorText?.let {
                isLoading = false
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = it
                )
            }
        }
    }
}
