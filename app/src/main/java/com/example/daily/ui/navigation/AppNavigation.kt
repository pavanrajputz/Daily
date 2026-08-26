package com.example.daily.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.daily.ui.habit.EditHabitScreen


object Routes {

    const val ONBOARDING = "onboarding"
    const val LOGIN = "login"
    const val SIGNUP = "signup"

    const val CREATE_HABIT = "create_habit"

    const val EDIT_HABIT = "edit_habit"
}


@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = Routes.EDIT_HABIT
    ) {
        composable(Routes.EDIT_HABIT) {
            EditHabitScreen(

                onBack = {
                    navController.popBackStack()
                },

                onSave = {
                    navController.popBackStack()
                },

                onCancel = {
                    navController.popBackStack()
                }
            )
        }
    }
}