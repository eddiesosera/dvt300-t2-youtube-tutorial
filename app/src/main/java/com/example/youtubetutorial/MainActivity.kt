package com.example.youtubetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.youtubetutorial.ui.theme.YoutubeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YoutubeTutorialTheme {
                LoginContainer()
            }
        }
    }
}

@Composable
fun LoginContainer(modifier: Modifier = Modifier) {

//TODO: Top Section = 1. Add bg image
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF090011)),
    ) {

        //TODO: Form Section = 1. Add logo image
        LoginBackground(
            Modifier
                .fillMaxWidth()
                .height(210.dp)
        )

        //TODO: Form Section
        Column(
            modifier = Modifier
                // .offset(y = (150).dp)
                .padding(top=150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            //TODO: Form Section = 2. Add header and tagline
            HeaderSection()

            //TODO: FORM
            FormWrap()

        }

    }
}

@Composable
fun LoginBackground(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Login Background",
        modifier = modifier.height(200.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //FONTS
        val babasFamily = FontFamily(
            Font(R.font.bebasneue)
        )
        val interFamily = FontFamily(
            Font(R.font.inter)
        )
        val interBoldFamily = FontFamily(
            Font(R.font.interbold)
        )

        Column(
            modifier = Modifier
                .height(113.dp)
                .width(113.dp)
                .background(Color(0xFFF2994A), RoundedCornerShape(100.dp)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(78.dp)
                    .width(78.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "LOGIN",
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyle(
                    fontFamily = babasFamily,
                    fontSize = 56.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                //color = Color()
            )
            Text(
                text = "Explore the Galaxy",
                modifier = Modifier
                    .width(300.dp),
                style = TextStyle(
                    fontFamily = interBoldFamily,
                    fontSize = 18.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            )
        }
    }

}

@Composable
fun FormWrap() {
    var textValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var checkedValue by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(40.dp)
    ) {

        //TODO: Form Section = 3. Input Section -> Email label & input
        Column {
            //Input label
            Text(
                text = "Your email",
                style = TextStyle(
                    color = Color.White,
                )
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            //Input component
            TextField(
                value = textValue,
                onValueChange = { textValue = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(30.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                )
            )
        }

        Spacer(modifier = Modifier.padding(bottom = 20.dp))

        //TODO: Form Section = 4. Input Section -> Password label & input
        Column {
            //Input label
            Text(
                text = "Your password",
                style = TextStyle(
                    color = Color.White,
                )
            )
            Spacer(modifier = Modifier.padding(bottom = 10.dp))
            //Input component
            TextField(
                value = passwordValue,
                onValueChange = { passwordValue = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(30.dp))
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = RoundedCornerShape(30.dp)
                    ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                )
            )
        }

        //TODO: Form Section = 5. Check box with label and Forgot Password
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                //modifier = Modifier.fillMaxSize()
            ) {
                Checkbox(
                    checked = false,
                    onCheckedChange = { checkedValue = it }
                )
                //Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Remember Me",
                    fontSize = 14.sp,
                    style = TextStyle(
                        color = Color.White
                    )
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "Forgot Password?",
                    //modifier = Modifier.fillMaxSize(),
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color(0xFFF2994A),
                        textAlign = TextAlign.Center,
                    )
                )
            }

        }

        Row(
            modifier = Modifier
                .fillMaxHeight(),
               // .offset(y = (-75).dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            //TODO: Submission Button
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF7920C2), // Background color
                    contentColor = Color(0xFFFFFFFF) // Text color
                ),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Login"
                )
            }
        }

    }
}

@Preview(showBackground = true, widthDp = 393, heightDp = 851)
@Composable
fun LoginScreen() {
    YoutubeTutorialTheme {
        LoginContainer()
    }
}