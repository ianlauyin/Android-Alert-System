package com.example.android_alert_system.component

import android.Manifest
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun RequestPermissionButton(hasNotificationPermission:MutableState<Boolean>){
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { hasNotificationPermission.value = it }
    )
    Button(onClick= {permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)}){
        Text(text="Please Give Notification Permission Before Start")
    }
}