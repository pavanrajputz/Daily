package com.example.daily.ui.habit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.Replay
import androidx.compose.material.icons.filled.Vibration
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daily.ui.theme.DailyBackground
import com.example.daily.ui.theme.DailyPrimary
import com.example.daily.ui.theme.DailyPrimaryDark
import com.example.daily.ui.theme.DailyTextPrimary
import com.example.daily.ui.theme.DailyTextSecondary


@Composable
fun ReminderScreen(
    onBack: () -> Unit,
    onContinue: () -> Unit
){

    val notificationEnabled = remember {
        mutableStateOf(true)
    }

    val soundEnabled = remember {
        mutableStateOf(false)
    }

    val vibrationEnabled = remember {
        mutableStateOf(true)
    }

    val repeatIfMissed = remember {
        mutableStateOf(false)
    }


    Column(
        modifier = Modifier.fillMaxSize()
            .padding(20.dp, 60.dp)
            .background(DailyBackground)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //back Butoon
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = DailyTextPrimary
                )
            }

            //upper header texts
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Choose Category",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DailyTextPrimary
                )

                Text(
                    text = "Step 4 of 4",
                    fontSize = 12.sp,
                    color = DailyTextSecondary
                )
            }
            Spacer(
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        // Time section
        TimePickerCard()

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(16.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 16.dp)
        ){
            ReminderSettingRow(
                icon = Icons.Default.NotificationsActive,
                title = "Enable Notification",
                subtitle = "Receive push alerts",
                enabled = notificationEnabled.value,
                onToggle = {
                    notificationEnabled.value =
                        !notificationEnabled.value
                }
            )

            ReminderSettingRow(
                icon = Icons.Default.NotificationsActive,
                title = "Enable Notification",
                subtitle = "Receive push alerts",
                enabled = notificationEnabled.value,
                onToggle = {
                    notificationEnabled.value =
                        !notificationEnabled.value
                }
            )


            ReminderSettingRow(
                icon = Icons.Default.Vibration,
                title = "Vibration",
                subtitle = "Vibrate when reminder appears",
                enabled = vibrationEnabled.value,
                onToggle = {
                    vibrationEnabled.value =
                        !vibrationEnabled.value
                }
            )

            ReminderSettingRow(
                icon = Icons.Default.Replay,
                title = "Repeat if Missed",
                subtitle = "Every 5 mins (Max 3)",
                enabled = repeatIfMissed.value,
                onToggle = {
                    repeatIfMissed.value =
                        !repeatIfMissed.value
                }
            )

        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        // Preview
        ReminderPreview()

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        //button
        Spacer(modifier = Modifier.height(28.dp))

        Button(
            onClick = onContinue,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DailyPrimary
            )
        ){
            Text(
                text = "Finish",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(12.dp))

    }
}


@Composable
private fun TimePickerCard() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.White,
                RoundedCornerShape(16.dp)
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(16.dp)
    ) {

        Text(
            text = "Set Time",
            fontSize = 13.sp,
            fontWeight = FontWeight.SemiBold,
            color = DailyTextSecondary
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TimeColumn(
                values = listOf("05", "06", "07", "08"),
                selected = "07"
            )

            Text(
                text = ":",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = DailyTextPrimary,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            TimeColumn(
                values = listOf("58", "59", "00", "01"),
                selected = "00"
            )

            Spacer(
                modifier = Modifier.width(20.dp)
            )

            Column {

                TimeOption(
                    text = "AM",
                    selected = true
                )

                TimeOption(
                    text = "PM",
                    selected = false
                )
            }
        }
    }
}


@Composable
private fun TimeColumn(
    values: List<String>,
    selected: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        values.forEach { value ->

            Text(
                text = value,
                fontSize = if (value == selected) {
                    22.sp
                } else {
                    16.sp
                },
                fontWeight = if (value == selected) {
                    FontWeight.Bold
                } else {
                    FontWeight.Normal
                },
                color = if (value == selected) {
                    DailyPrimary
                } else {
                    DailyTextSecondary
                },
                modifier = Modifier.padding(
                    vertical = 4.dp
                )
            )
        }
    }
}


@Composable
private fun TimeOption(
    text: String,
    selected: Boolean
) {

    Box(
        modifier = Modifier
            .size(
                width = 42.dp,
                height = 34.dp
            )
            .background(
                color = if (selected) {
                    DailyPrimary
                } else {
                    Color(0xFFE8EDF7)
                },
                shape = RoundedCornerShape(6.dp)
            ),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = if (selected) {
                Color.White
            } else {
                DailyTextSecondary
            }
        )
    }

    Spacer(
        modifier = Modifier.height(4.dp)
    )
}


@Composable
private fun ReminderSettingRow(
    icon: ImageVector,
    title: String,
    subtitle: String,
    enabled: Boolean,
    onToggle: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Box(
            modifier = Modifier
                .size(38.dp)
                .background(
                    DailyPrimary.copy(alpha = 0.10f),
                    RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = DailyPrimary,
                modifier = Modifier.size(20.dp)
            )
        }

        Spacer(
            modifier = Modifier.width(12.dp)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {

            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = DailyTextPrimary
            )

            Text(
                text = subtitle,
                fontSize = 11.sp,
                color = DailyTextSecondary
            )
        }

        Switch(
            checked = enabled,
            onCheckedChange = {
                onToggle()
            }
        )
    }
}


@Composable
private fun ReminderPreview() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                DailyPrimary.copy(alpha = 0.08f),
                RoundedCornerShape(14.dp)
            )
            .border(
                width = 1.dp,
                color = DailyPrimaryDark,
                shape = RoundedCornerShape(14.dp)
            )
            .padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                tint = DailyPrimary,
                modifier = Modifier.size(20.dp)
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Text(
                text = "Reminder Preview",
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = DailyPrimary
            )
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "\"Morning Run starts at 7:00 AM\"",
            fontSize = 12.sp,
            color = DailyTextSecondary
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ReminderScreenPreview(){
    com.example.daily.ui.theme.DailyTheme() {
        ReminderScreen(
            onBack = {},
            onContinue = {}
        )
    }
}