package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.telephony.TelephonyManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val imsi = IMSIHelper.getIMSI(applicationContext)
                    Greeting(imsi)
                }
            }
        }
    }

    object IMSIHelper {
        fun getIMSI(context: Context): String? {
            return try {
                val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager?
                telephonyManager?.subscriberId // IMSI
            } catch (e: SecurityException) {
                // Handle the exception (e.g., permission denied)
                e.printStackTrace()
                null
            }
        }
    }

    @Composable
    fun Greeting(imsi: String?, modifier: Modifier = Modifier) {
        Text(
            text = "IMSI: ${imsi ?: "Not fetched"}",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MyApplicationTheme {
            Greeting("Android")
        }
    }
}
