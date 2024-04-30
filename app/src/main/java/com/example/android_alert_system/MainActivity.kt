package com.example.android_alert_system

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_alert_system.component.RequestPermissionButton
import com.example.android_alert_system.ui.theme.AndroidAlertSystemTheme

class MainActivity : ComponentActivity() {
    private var hasNotificationPermission= mutableStateOf(false)
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAlertSystemTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if (hasNotificationPermission.value) {
                        StartButton()
                    } else {
                        RequestPermissionButton(hasNotificationPermission)
                    }
                }
            }
        }
    }
}

@Composable
fun StartButton() {
    Text(text = "Click Me")
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    AndroidAlertSystemTheme {
        StartButton()
    }
}