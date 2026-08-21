package com.example.daily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.example.daily.ui.auth.LoginScreen
import com.example.daily.ui.onboarding.OnboardingPage
import com.example.daily.ui.onboarding.OnboardingScreen
import com.example.daily.ui.theme.DailyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DailyTheme {
                LoginScreen(
                    onLogin = {},
                    onSignUp = {},
                    onForgotPassword = {},
                    onGoogleLogin = {}
                )
            }
        }
    }
}

@Composable


private fun DailyOnboarding() {

    val pages = listOf(

        OnboardingPage(
            image = R.drawable.onboarding_welcome,
            title = "Small habits.\nBig results.",
            description = "Create simple daily routines that improve your life one day at a time."
        ),

        OnboardingPage(
            image = R.drawable.onboarding_progress,
            title = "Track your progress",
            description = "Stay motivated with beautiful statistics and daily streak tracking."
        ),

        OnboardingPage(
            image = R.drawable.onboarding_consistency,
            title = "Become consistent",
            description = "Consistency beats perfection. Complete tiny habits every day."
        )
    )

    val pageIndexState = remember {
        mutableIntStateOf(0)
    }

    val pageIndex = pageIndexState.intValue

    OnboardingScreen(
        page = pages[pageIndex],
        pageIndex = pageIndex,
        totalPages = pages.size,

        onNext = {
            if (pageIndexState.intValue < pages.lastIndex) {
                pageIndexState.intValue++
            }
        },

        onPrevious = {
            if (pageIndexState.intValue > 0) {
                pageIndexState.intValue--
            }
        },

        onSkip = {
            // Login navigation will be added later.
        }
    )
}