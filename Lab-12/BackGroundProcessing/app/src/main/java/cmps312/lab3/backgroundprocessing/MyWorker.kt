package cmps312.lab3.backgroundprocessing

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

class MyWorker(private val context: Context, workerParams: WorkerParameters) :
    CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = coroutineScope {
        aLongRunningTask()
        showNotification("Completed running the long running operation!")
        Result.success()
    }

    suspend fun aLongRunningTask() {
        Log.d("TAG", "aLongRunningTask started executig ")
        delay(1000 * 3)
        Log.d("TAG", "aLongRunningTask finished executing ")
    }

    fun showNotification(message: String) {
        val manager: NotificationManager = applicationContext
            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create an explicit intent for an Activity in your app
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(applicationContext,
            0, intent, 0)

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "BackgroundWorkID", "Background Process Channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notification = NotificationCompat
                .Builder(applicationContext,"Likes" )
                .setContentTitle("Background work")
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build()

            manager.createNotificationChannel(channel)
            manager.notify(101, notification)
        }
    }
}