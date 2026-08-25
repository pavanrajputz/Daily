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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.LocalDrink
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daily.ui.theme.DailyBackground
import com.example.daily.ui.theme.DailyPrimary
import com.example.daily.ui.theme.DailyTextPrimary
import com.example.daily.ui.theme.DailyTextSecondary

@Composable
fun CreateHabitDetailsScreen(
    onBack: () -> Unit,
    onContinue: () -> Unit
){
    val habitNameState = remember {
        mutableStateOf("")
    }

    val descriptionState = remember {
        mutableStateOf("")
    }

    val selectedIconState = remember {
        mutableStateOf(0)
    }


    //icons list
    val icons = listOf(
        Icons.Default.FitnessCenter,
        Icons.AutoMirrored.Filled.MenuBook,
        Icons.Default.LocalDrink,
        Icons.Default.Spa,
        Icons.Default.Work,
        Icons.Default.Timer,
        Icons.Default.Book,
        Icons.Default.MusicNote,
        Icons.Default.Computer,
        Icons.Default.LocalFlorist,
        Icons.Default.Brush,
        Icons.Default.FavoriteBorder
    )

    //here starts the screen
    Column(
        modifier = Modifier.fillMaxSize()
            .background(DailyBackground)
            .verticalScroll(rememberScrollState())
            .padding(20.dp, 60.dp)
    ) {

        //header
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

            //main headings
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) { 
                
                //Main heading
                Text(
                    text = "Create habit",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = DailyTextPrimary
                )
                
                //steps heading
                Text(
                    text = "step 1 of 4",
                    fontSize = 12.sp,
                    color = DailyTextSecondary
                )
            }
            Spacer(modifier = Modifier.width(48.dp))
        }

        //upper row closed & below content starts
        Spacer(modifier = Modifier.height(32.dp))

        //text
        Text(
            text = "Habit Name",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = DailyTextPrimary
        )

        //input
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = habitNameState.value,
            onValueChange = {
                habitNameState.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Example: Morning run")
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )


        Spacer(modifier = Modifier.height(20.dp))
        //text
        Text(
            text = "Description (Optional)",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = DailyTextPrimary
        )

        //input
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = descriptionState.value,
            onValueChange = {
                descriptionState.value = it
            },
            modifier = Modifier.fillMaxWidth()
                .height(110.dp),
            placeholder = {
                Text("Brief details to movtivate you...")
            },
            maxLines = 4,
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
        //Icons Box
        //Icon heading
        Text(
            text = "Choose Icon",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.SemiBold,
            color = DailyTextPrimary
        )
        
        //Icons grid
        Column(
            modifier = Modifier.fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(20.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            icons.chunked(4).forEachIndexed { rowIndex, rowIcons ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    rowIcons.forEachIndexed { columnIndex, icon ->
                        val index = rowIndex*4 + columnIndex
                        val selected = selectedIconState.value == index

                        Box(
                            modifier = Modifier.size(52.dp)
                                .background(
                                   color =  if(selected){
                                       DailyPrimary.copy(alpha = 0.10f)
                                   }else{
                                       Color.Transparent
                                   },
                                    shape = RoundedCornerShape(50)
                                )
                                .clickable{
                                    selectedIconState.value = index
                                },
                            contentAlignment = Alignment.Center
                        ){
                            Icon(
                                imageVector = icon,
                                contentDescription = null,
                                tint = if (selected) {
                                    DailyPrimary
                                } else {
                                    DailyTextSecondary
                                },
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    }
                }
            }

        }

        Spacer(modifier = Modifier.height(32.dp))
        //continue button
        Button(
            onClick = onContinue,
            modifier = Modifier.fillMaxWidth()
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


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CreateHabitDetailsScreenPreview(){
    com.example.daily.ui.theme.DailyTheme {
        CreateHabitDetailsScreen(
            onBack = {},
            onContinue = {}
        )
    }
}