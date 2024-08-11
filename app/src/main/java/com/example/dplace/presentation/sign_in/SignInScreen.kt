package com.example.dplace.presentation.sign_in

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dplace.R

@Composable
fun SignInScreen (
    state: SignInState,
    onSignInClick: () -> Unit
){
    val context = LocalContext.current
    LaunchedEffect(key1 = state.signInError){
        state.signInError?.let { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        Text(
            modifier = Modifier
                .offset(y = 150.dp)
                .align(Alignment.TopCenter),
            text = "D/place",
            color = Color(0xff0fc100),
            fontSize = 60.sp
        )
        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .height(200.dp)
                .width(340.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xff0fc100))
                .padding(2.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color.Black)
        ){
            Column (modifier = Modifier.fillMaxSize()){
                Box(modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 10.dp)){
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        onClick = {
                            onSignInClick()
                        }
                    ) {
                    }
                    Text(
                        modifier = Modifier
                            .offset(x = 30.dp)
                            .align(Alignment.CenterStart),
                        text = "Login with google",
                        fontSize = 20.sp,
                    )
                    Image(
                        modifier = Modifier
                            .offset(x = -(50).dp)
                            .align(Alignment.CenterEnd)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "google"
                    )
                }


                Box(modifier = Modifier.padding(start = 20.dp, end = 20.dp)){
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        onClick = { /*TODO*/ }
                    ) {
                    }
                    Text(
                        modifier = Modifier
                            .offset(x = 30.dp)
                            .align(Alignment.CenterStart),
                        text = "Login with x",
                        fontSize = 20.sp,
                    )
                    Image(
                        modifier = Modifier
                            .offset(x = -(50).dp)
                            .align(Alignment.CenterEnd)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.twitter),
                        contentDescription = "x"
                    )
                }


                Box(modifier = Modifier.padding(start = 20.dp, end = 20.dp)){
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        onClick = { /*TODO*/ }
                    ) {
                    }
                    Text(
                        modifier = Modifier
                            .offset(x = 30.dp)
                            .align(Alignment.CenterStart),
                        text = "Login with x",
                        fontSize = 20.sp,
                    )
                    Image(
                        modifier = Modifier
                            .offset(x = -(50).dp)
                            .align(Alignment.CenterEnd)
                            .size(30.dp),
                        painter = painterResource(id = R.drawable.github),
                        contentDescription = "github"
                    )
                }
            }
        }
    }
}