package com.example.daily.ui.habit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daily.ui.theme.DailyBackground
import com.example.daily.ui.theme.DailyPrimary
import com.example.daily.ui.theme.DailyTextPrimary
import com.example.daily.ui.theme.DailyTextSecondary

@Composable
fun RepeatScheduleScreen(
    onBack: () -> Unit,
    onContinue: () -> Unit
){

    val selectedFrequencyState = remember {
        mutableStateOf("Daily")
    }

    val selectedDaysState = remember {
        mutableStateOf(
            setOf(
                "M", "W","F"
            )
        )
    }

    val frequencies = listOf(
        "Daily",
        "Weekdays",
        "Weekends",
        "Weekly",
        "Monthly",
        "Custom"
    )

    val days = listOf(
        "M", "T", "W", "T", "F", "S", "S"
    )


    Column(
        modifier = Modifier.fillMaxSize()
            .background(DailyBackground)
            .verticalScroll(rememberScrollState())
            .padding(20.dp, 40.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //back button
            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = DailyTextPrimary
                )
            }

            //headings
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //Main heading
                Text(
                    text = "Repeat Schedule",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DailyPrimary
                )

                //steps heading
                Text(
                    text = "step 2 of 4",
                    fontSize = 12.sp,
                    color = DailyTextSecondary
                )
            }
            Spacer(
                modifier = Modifier.size(48.dp)
            )
        }

        //upper row closed below content starts
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "How often?",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = DailyTextPrimary
        )

        Spacer(modifier = Modifier.height(8.dp))
        //frequency grid
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            frequencies.chunked(2).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ){
                    row.forEach { frequency ->

                        val selected =
                            selectedFrequencyState.value == frequency

                        FrequencyCard(
                            title = frequency,
                            selected = selected,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                selectedFrequencyState.value = frequency
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        //Selected Days Cards
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Select specific days",
                    fontWeight = FontWeight.SemiBold,
                    color = DailyTextPrimary
                )

                Text(
                    text = "${selectedDaysState.value.size} days selected",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DailyPrimary,
                    modifier = Modifier
                        .background(
                            DailyPrimary.copy(alpha = 0.10f),
                            RoundedCornerShape(12.dp)
                        )
                        .padding(
                            horizontal = 10.dp,
                            vertical = 6.dp
                        )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                days.forEachIndexed { index, day ->

                    val dayKey = "$day$index"

                    val selected =
                        selectedDaysState.value.contains(dayKey)

                    DayCircle(
                        day = day,
                        selected = selected,
                        onClick = {

                            val current =
                                selectedDaysState.value.toMutableSet()

                            if (selected) {
                                current.remove(dayKey)
                            } else {
                                current.add(dayKey)
                            }

                            selectedDaysState.value = current
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = buildScheduleDescription(
                    selectedFrequencyState.value,
                    selectedDaysState.value
                ),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
                color = DailyTextSecondary
            )
        }
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
        ) {

            Text(
                text = "Continue",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
    }
}

//frequency Card
@Composable
private fun FrequencyCard(
    title: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
            .height(78.dp)
            .background(
                color = if (selected) {
                    DailyPrimary.copy(alpha = 0.08f)
                } else {
                    Color.White
                },
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick()
            }
            .padding(12.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.CalendarMonth,
            contentDescription = null,
            tint = if (selected) {
                DailyPrimary
            } else {
                DailyTextSecondary
            },
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = title,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected) {
                DailyPrimary
            } else {
                DailyTextPrimary
            }
        )
    }
}


//day circle
@Composable
private fun DayCircle(
    day: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = day,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            color = DailyTextSecondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        Box(
            modifier = Modifier
                .size(30.dp)
                .background(
                    color = if (selected) {
                        DailyPrimary
                    } else {
                        Color(0xFFE8EDF7)
                    },
                    shape = RoundedCornerShape(50)
                )
                .clickable {
                    onClick()
                },
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = if (selected) "✓" else "",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


//description helper
private fun buildScheduleDescription(
    frequency: String,
    selectedDays: Set<String>
): String {

    return when (frequency) {

        "Daily" ->
            "Habit repeats every day."

        "Weekdays" ->
            "Habit repeats every weekday."

        "Weekends" ->
            "Habit repeats every weekend."

        "Weekly" ->
            "Habit repeats once every week."

        "Monthly" ->
            "Habit repeats once every month."

        "Custom" -> {

            if (selectedDays.isEmpty()) {
                "Select the days for your habit."
            } else {
                "Habit repeats on ${selectedDays.size} selected days."
            }
        }

        else ->
            ""
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RepeatScheduleScreenPreview(){
    com.example.daily.ui.theme.DailyTheme {
        RepeatScheduleScreen(
            onBack = {},
            onContinue = {}
        )
    }
}