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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daily.ui.theme.DailyBackground
import com.example.daily.ui.theme.DailyPrimary
import com.example.daily.ui.theme.DailyTextPrimary
import com.example.daily.ui.theme.DailyTextSecondary


@Composable
fun EditHabitScreen(
    onBack: () -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit
){

    val habitNameState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }

    val selectedCategory = remember {
        mutableStateOf("Fitness")
    }

    val selectedColor = remember {
        mutableStateOf(DailyPrimary)
    }

    val selectedDays = remember {
        mutableStateOf(
            setOf("M", "W", "F")
        )
    }

    val notificationsEnabled = remember {
        mutableStateOf(true)
    }


    Column(
        modifier = Modifier.fillMaxSize()
            .background(DailyBackground)
            .verticalScroll(rememberScrollState())
            .padding(20.dp, 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //upper header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            //back button
            IconButton(
                onClick = {}
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = DailyTextPrimary
                )
            }

            //title
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Edit Habit",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DailyTextPrimary
                )
            }

            Spacer(
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        //basic details editing
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {


            //habits name taking
            Text(
                text = "Habit Name",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = DailyTextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = habitNameState.value,
                onValueChange = {
                    habitNameState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Example: Evening walk")
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )


            //description input taking
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Description",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = DailyTextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = descriptionState.value,
                onValueChange = {
                    descriptionState.value = it
                },
                modifier = Modifier.fillMaxWidth()
                    .height(110.dp),
                placeholder = {
                    Text("2 miles around the park")
                },
                maxLines = 4,
                shape = RoundedCornerShape(12.dp)
            )


            //ohter arbitraries taking
            Spacer(modifier = Modifier.height(20.dp))

            //dropdowns
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                //category dropdown
                Column(
                    modifier = Modifier.weight(1f),
                ) {

                    EditSelector(
                        label = "Category",
                        value = selectedCategory.value,
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {}
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                //icon dropdown
                Column(
                    modifier = Modifier.weight(1f),
                ) {

                    EditSelector(
                        label = "Icon",
                        value = "Running",
                        modifier = Modifier.fillMaxWidth(),
                        icon = Icons.AutoMirrored.Filled.DirectionsRun,
                        onClick = {}
                    )

                }
            }
            Spacer(modifier = Modifier.height(20.dp))

            //colors work
            val colors = listOf(
                DailyPrimary,
                Color(0xFF3F7FF5),
                Color(0xFFF0B400),
                Color(0xFFF04444),
                Color(0xFF8B5CF6)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(

                ) {
                    Text(
                        text = "Color tag",
                        fontSize = 14.sp,
                        color = DailyTextSecondary
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        colors.forEach { color ->

                            ColorOption(
                                color = color,
                                selected = selectedColor.value == color,
                                onClick = {
                                    selectedColor.value = color
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        //schedule

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.White,
                    RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            Text(
                text = "Schedule",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = DailyTextPrimary
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Repeat Days",
                fontSize = 12.sp,
                color = DailyTextPrimary
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            val days = listOf(
                "S", "M", "T", "W", "T", "F", "S"
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                days.forEachIndexed { index, day ->

                    val dayKey = "$day$index"

                    val selected =
                        selectedDays.value.contains(dayKey)

                    DayOption(
                        day = day,
                        selected = selected,
                        onClick = {

                            val updated =
                                selectedDays.value.toMutableSet()

                            if (selected) {
                                updated.remove(dayKey)
                            } else {
                                updated.add(dayKey)
                            }

                            selectedDays.value = updated
                        }
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color(0xFFE5E7EB))
            )

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Text(
                text = "Reminder Time",
                fontSize = 12.sp,
                color = DailyTextPrimary
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "06:30 AM",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = DailyTextPrimary,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "Edit",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = DailyPrimary,
                    modifier = Modifier.clickable {
                        // Time picker will be connected later.
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Notifications",
                    fontSize = 14.sp,
                    color = DailyTextPrimary,
                    modifier = Modifier.weight(1f)
                )

                Switch(
                    checked = notificationsEnabled.value,
                    onCheckedChange = {
                        notificationsEnabled.value = it
                    }
                )
            }
        }

        //save button
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Button(
            onClick = onSave,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DailyPrimary
            )
        ) {

            Text(
                text = "Save Changes",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        //cancel button
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = "Cancel",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onCancel()
                },
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = DailyTextPrimary
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )
    }
    //main column ends here
}
//function ends here



@Composable
private fun EditSelector(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    icon: androidx.compose.ui.graphics.vector.ImageVector? = null,
    onClick: () -> Unit
) {

    Column(
        modifier = modifier
    ) {

        Text(
            text = label,
            fontSize = 12.sp,
            color = DailyTextPrimary
        )

        Spacer(
            modifier = Modifier.height(6.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .border(
                    width = 1.dp,
                    color = Color(0xFFC5D2C5),
                    shape = RoundedCornerShape(8.dp)
                )
                .clip(
                    RoundedCornerShape(8.dp)
                )
                .clickable {
                    onClick()
                }
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            if (icon != null) {

                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = DailyTextPrimary,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )
            }

            Text(
                text = value,
                fontSize = 14.sp,
                color = DailyTextPrimary,
                modifier = Modifier.weight(1f)
            )

            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Select",
                tint = DailyTextSecondary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}



@Composable
private fun ColorOption(
    color: Color,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(42.dp)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        if (selected) {

            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        Color.White,
                        CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = color,
                        shape = CircleShape
                    )
            )
        }

        Box(
            modifier = Modifier
                .size(
                    if (selected) 34.dp else 36.dp
                )
                .background(
                    color,
                    CircleShape
                )
        )
    }
}


@Composable
private fun DayOption(
    day: String,
    selected: Boolean,
    onClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .size(34.dp)
            .background(
                color = if (selected) {
                    DailyPrimary
                } else {
                    Color.White
                },
                shape = CircleShape
            )
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = day,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = if (selected) {
                Color.White
            } else {
                DailyTextPrimary
            }
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun EditHabitScreenPreview(){
    com.example.daily.ui.theme.DailyTheme {
        EditHabitScreen(
            onBack = {},
            onSave = {},
            onCancel = {}
        )
    }
}