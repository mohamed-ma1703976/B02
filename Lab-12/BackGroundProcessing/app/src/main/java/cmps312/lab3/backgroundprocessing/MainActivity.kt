package cmps312.lab3.backgroundprocessing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.work.*
import cmps312.lab3.backgroundprocessing.ui.theme.BackGroundProcessingTheme
import java.lang.reflect.Modifier
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BackGroundProcessingTheme {
                // A surface container using the 'background' color from the theme
                var jobState by remember { mutableStateOf("") }
                Surface(color = MaterialTheme.colors.background

                ) {
                    val context= LocalContext.current
                    val constraint = Constraints.Builder()
                        .setRequiresBatteryNotLow(true)
                        .setRequiredNetworkType(NetworkType.CONNECTED).build()

                        val periodicRequest =
                            PeriodicWorkRequestBuilder<MyWorker>(15, TimeUnit.DAYS)
                                .setConstraints(constraint)
                                .build()

                        val oneTimeRequest = OneTimeWorkRequestBuilder<MyWorker>()
                            .setConstraints(constraint)
                            .build()
                        Column(

                            verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = androidx.compose.ui.Modifier.padding(40.dp))
                            Column(verticalArrangement = Arrangement.Bottom) {
                                Text(text = jobState)
                            }

                            Button(onClick = {
                                WorkManager.getInstance(context).enqueue(oneTimeRequest)
                            }) {
                                Text(text = "Do one time work")
                            }
                            Button(onClick = {
                                WorkManager.getInstance(context).enqueue(periodicRequest)
                            }) {
                                Text(text = "Schedule Periodic work")
                            }

                        }

                    WorkManager.getInstance(this)
                        .getWorkInfoByIdLiveData(oneTimeRequest.id)
                        .observe(this) {
                            jobState=it.state.name
                        }



                    }
                }
            }
        }
    }


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BackGroundProcessingTheme {
        Greeting("Android")
    }
}