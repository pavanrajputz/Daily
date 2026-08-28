package com.example.daily.ui.habit

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
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import com.example.daily.ui.theme.DailyBackground
import com.example.daily.ui.theme.DailyPrimary
import com.example.daily.ui.theme.DailyTextPrimary


@Composable
fun HabitDetailsScreen(
    onBack: () -> Unit,
    onEditHabit: () -> Unit
){
    Scaffold(
        containerColor = DailyBackground,
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = onBack
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = DailyTextPrimary
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "More options",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DailyBackground
                )
            )
        },

        bottomBar = {
            HabitDetailsBottomNavigation()
        }
    ) {
        innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().
            padding(innerPadding).
            verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp).
            padding(vertical = 60.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            HabitHeader()

            Spacer(modifier = Modifier.height(24.dp))

            HabitCalendarPlaceHolder()

            Spacer(modifier = Modifier.height(24.dp))

            HabitStatisticsPlaceholder()

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DailyPrimary,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Edit Habit",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }

        }
    }
}


//Habit header goes here
@Composable
private fun HabitHeader(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier.size(88.dp),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = HabitSecondaryContainer
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.DirectionsRun,
                        contentDescription = "habit icon"
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Text(
                text = "Morning Run",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                HabitChip(
                    text = "Fitness"
                )

                Spacer(modifier = Modifier.width(8.dp))

                HabitChip(
                    text = "🔥 18 Days"
                )

                Spacer(modifier = Modifier.width(8.dp))

                HabitChip(
                    text = "92%"
                )
            }
        }
    }
}



@Composable
private fun HabitCalendarPlaceHolder(){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "This Month",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "August 2026",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Calendar will be implemented next",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                listOf(
                    "M", "T", "W", "T", "F", "S", "S"
                ).forEach { day ->

                    Text(
                        text = day,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                repeat(7) {
                    Card(
                        modifier = Modifier.size(42.dp),
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = HabitSurfaceContainer
                        )
                    ) {}
                }
            }
        }
    }
}


@Composable
private fun HabitStatisticsPlaceholder() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        HabitStatCard(
            modifier = Modifier.weight(1f),
            title = "Longest Streak",
            value = "24 Days"
        )

        HabitStatCard(
            modifier = Modifier.weight(1f),
            title = "Completion",
            value = "92%"
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        HabitStatCard(
            modifier = Modifier.weight(1f),
            title = "Missed Days",
            value = "2"
        )

        HabitStatCard(
            modifier = Modifier.weight(1f),
            title = "Current Month",
            value = "14/31"
        )
    }
}


@Composable
private fun HabitStatCard(
    modifier: Modifier = Modifier,
    title: String,
    value: String
) {

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(18.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

//habit chips used in habit headers

@Composable
private fun HabitChip(
    text: String
) {

    Card(
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {

        Text(
            text = text,
            modifier = Modifier.padding(
                horizontal = 14.dp,
                vertical = 7.dp
            ),
            style = MaterialTheme.typography.labelLarge,
            color = Color.DarkGray
        )
    }
}



@Composable
private fun HabitDetailsBottomNavigation() {

    NavigationBar(
        containerColor = Color.White,
        modifier = Modifier.navigationBarsPadding()
    ) {

        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Home,
                    contentDescription = "Home"
                )
            },
            label = {
                Text("Home")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.CalendarMonth,
                    contentDescription = "Calendar"
                )
            },
            label = {
                Text("Calendar")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.PieChart,
                    contentDescription = "Stats"
                )
            },
            label = {
                Text("Stats")
            }
        )

        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "Profile"
                )
            },
            label = {
                Text("Profile")
            }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HabitScreenScreenPreview(){
    com.example.daily.ui.theme.DailyTheme {
        HabitDetailsScreen(
            onBack = {},
            onEditHabit = {}
        )
    }
}