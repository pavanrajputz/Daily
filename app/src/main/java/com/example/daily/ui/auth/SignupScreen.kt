package com.example.daily.ui.auth

import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.daily.ui.theme.DailyBackground
import com.example.daily.ui.theme.DailyPrimary
import com.example.daily.ui.theme.DailyTextPrimary
import com.example.daily.ui.theme.DailyTextSecondary

@Composable
fun SignupScreen(
    onCreateAccount: () -> Unit,
    onLogin: () -> Unit
){
    val fullNameState = remember { mutableStateOf("") }
    val emailState = remember { mutableStateOf("") }
    val passwordState = remember { mutableStateOf("") }
    val confirmPasswordState = remember { mutableStateOf("") }

    val passwordVisibleState = remember { mutableStateOf(false) }
    val confirmPasswordVisibleState = remember { mutableStateOf(false) }

    val termsAcceptedState = remember { mutableStateOf(false) }


    //whole screen content column
    Column(
        modifier = Modifier.fillMaxSize()
            .background(DailyBackground)
            .padding(20.dp, 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //logo
        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .width(68.dp)
                .height(68.dp)
                .background(
                    color = DailyPrimary,
                    shape = RoundedCornerShape(50)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "✓",
                color = Color.White,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }

        //heading
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Create Account",
            style = MaterialTheme.typography.headlineLarge,
            color = DailyTextPrimary,
            textAlign = TextAlign.Center
        )

        //subheading
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Start your habit journey today.",
            style = MaterialTheme.typography.bodyLarge,
            color = DailyTextSecondary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(20.dp)
        ){
            //full name
            Text(
                text = "Full Name",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = DailyTextPrimary
            )

            //naming box
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = fullNameState.value,
                onValueChange = {
                    fullNameState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("Jane Doe")
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            //Email text
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Email",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                color = DailyTextPrimary
            )

            //emailbox
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = emailState.value,
                onValueChange = {
                    emailState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = {
                    Text("your@gmail.com")
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            //password
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Password",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = DailyTextPrimary
            )

            //password box
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = passwordState.value,
                onValueChange = {
                    passwordState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password"
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibleState.value =
                                !passwordVisibleState.value
                        }
                    ) {
                        Icon(
                            imageVector = if (passwordVisibleState.value)
                                Icons.Default.VisibilityOff
                            else
                                Icons.Default.Visibility,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
                visualTransformation =
                    if (passwordVisibleState.value)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )

            //confirmpassword text
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Confirm Password",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = DailyTextPrimary
            )

            //confirmpassword box
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = confirmPasswordState.value,
                onValueChange = {
                    confirmPasswordState.value = it
                },
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "password"
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {
                            passwordVisibleState.value =
                                !passwordVisibleState.value
                        }
                    ) {
                        Icon(
                            imageVector = if (passwordVisibleState.value)
                                Icons.Default.VisibilityOff
                            else
                                Icons.Default.Visibility,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                },
                visualTransformation =
                    if(passwordVisibleState.value)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                singleLine = true,
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Terms
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = termsAcceptedState.value,
                onCheckedChange = {
                    termsAcceptedState.value = it
                }
            )

            Text(
                text = "I agree to the Terms & Privacy Policy.",
                color = DailyTextSecondary,
                fontSize = 14.sp
            )
        }

        //signup button
        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onCreateAccount,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(28.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DailyPrimary
            )
        ) {
            Text(
                text = "Create Account",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

        //already login text
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Already have an account? ",
                color = DailyTextSecondary
            )

            Text(
                text = "Login",
                color = DailyPrimary,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .clickable {
                        onLogin()
                    }
                    .padding(4.dp)
            )
        }
    }

}





@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SignupScreenPreview() {
    com.example.daily.ui.theme.DailyTheme {
        SignupScreen(
            onCreateAccount = {},
            onLogin = {}
        )
    }
}