package com.example.daily.ui.onboarding

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import com.example.daily.ui.theme.DailyBackground
import com.example.daily.ui.theme.DailyPrimary
import com.example.daily.ui.theme.DailyTextPrimary
import com.example.daily.ui.theme.DailyTextSecondary

@Composable
fun OnBoardingScreen(
    page: OnboardingPage,
    pageIndex: Int,
    totalPages: Int,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onSkip: () -> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(DailyBackground)
        .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .hor) {
            Text(
                text = "Skip",
                color = DailyTextSecondary,
                modifier = Modifier.padding(8.dp)
            )
        }
        Spacer(Modifier.height(20.dp))
        Box(Modifier
            .fillMaxWidth()
            .height(360.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(DailyBackground),
            contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(page.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

        Spacer(Modifier.height(32.dp))
        Text(
            text = page.title,
            style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
            color = DailyTextPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(16.dp))
        Text(
            text = page.description,
            style = androidx.compose.material3.MaterialTheme.typography.bodyLarge,
            color = DailyTextSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(12.dp)
        )

        Spacer(Modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(totalPages){index ->
                Box(
                    modifier = Modifier
                        .height(8.dp)
                        .weight(
                            if(index == pageIndex) 32.dp else 8.dp
                        )
                        .clip(RoundedCornerShape(50.dp))
                        .background(
                            if(index == pageIndex){
                                DailyPrimary
                            }else{
                                DailyTextSecondary.copy(alpha = 0.25f)
                            }
                        )
                )
                if (index != totalPages - 1) {
                    Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
        Spacer(modifier = Modifier.height(24.dp))

        // Bottom buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            if (pageIndex > 0) {
                Text(
                    text = "Previous",
                    color = DailyPrimary,
                    modifier = Modifier
                        .padding(12.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            } else {
                Spacer(modifier = Modifier.width(80.dp))
            }

            Button(
                onClick = {
                    if (pageIndex == totalPages - 1) {
                        onSkip()
                    } else {
                        onNext()
                    }
                },
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DailyPrimary
                ),
                modifier = Modifier.height(56.dp)
            ) {
                Text(
                    text = when {
                        pageIndex == 0 -> "Get Started"
                        pageIndex == totalPages - 1 -> "Continue"
                        else -> "Next"
                    }
                )
            }
        }
    }
}