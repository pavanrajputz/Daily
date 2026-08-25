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
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.AccountBalanceWallet
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SelfImprovement
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.daily.ui.theme.DailyTextPrimary
import com.example.daily.ui.theme.DailyTextSecondary


@Composable
fun ChooseCategory(
    onBack: () -> Unit,
    onContinue: () -> Unit
){



    val selectedCategoryState = remember {
        mutableStateOf("Fitness")
    }

    val categories = listOf(
        CategoryItem(
            name = "Health",
            icon = Icons.Default.FavoriteBorder
        ),
        CategoryItem(
            name = "Fitness",
            icon = Icons.Default.FitnessCenter
        ),
        CategoryItem(
            name = "Study",
            icon = Icons.Default.School
        ),
        CategoryItem(
            name = "Work",
            icon = Icons.Default.Work
        ),
        CategoryItem(
            name = "Finance",
            icon = Icons.Default.AccountBalanceWallet
        ),
        CategoryItem(
            name = "Reading",
            icon = Icons.AutoMirrored.Filled.MenuBook
        ),
        CategoryItem(
            name = "Meditation",
            icon = Icons.Default.SelfImprovement
        ),
        CategoryItem(
            name = "Personal",
            icon = Icons.Default.Person
        ),
        CategoryItem(
            name = "Other",
            icon = Icons.Default.Add
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DailyBackground)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 60.dp)
    ){
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = onBack
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = DailyTextPrimary
                )
            }

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
                    text = "Step 3 of 4",
                    fontSize = 12.sp,
                    color = DailyTextSecondary
                )
            }
            Spacer(
                modifier = Modifier.size(48.dp)
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Category grid
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            categories.chunked(2).forEach { rowCategories ->

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {

                    rowCategories.forEach { category ->

                        val selected =
                            selectedCategoryState.value == category.name

                        CategoryCard(
                            category = category,
                            selected = selected,
                            modifier = Modifier.weight(1f)
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray,
                                    shape = RoundedCornerShape(12.dp)
                                ),
                            onClick = {
                                selectedCategoryState.value =
                                    category.name
                            }
                        )
                    }
                    // Keeps the last row aligned
                    if (rowCategories.size == 1) {
                        Spacer(
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
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
        ){
            Text(
                text = "Continue",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
    }
}

@Composable
private fun CategoryCard(
    category: CategoryItem,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    Box(
        modifier = modifier
            .height(92.dp)
            .background(
                color = if (selected) {
                    DailyPrimary.copy(alpha = 0.10f)
                } else {
                    Color.White
                },
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                imageVector = category.icon,
                contentDescription = category.name,
                tint = if (selected) {
                    DailyPrimary
                } else {
                    DailyTextSecondary
                },
                modifier = Modifier.size(25.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = category.name,
                color = if (selected) {
                    DailyPrimary
                } else {
                    DailyTextPrimary
                },
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

data class CategoryItem(
    val name: String,
    val icon: ImageVector
)


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ChooseCategoryPreview(){
    com.example.daily.ui.theme.DailyTheme {
        ChooseCategory(
            onBack = {},
            onContinue = {}
        )
    }
}