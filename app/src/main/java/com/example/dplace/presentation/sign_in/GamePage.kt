package com.example.dplace.presentation.sign_in

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GamePage(
    navController: NavController
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ){
        LazyVerticalGrid(
            modifier = Modifier
                .offset(y = 25.dp)
                .padding(start = 15.dp, end = 15.dp)
                .align(Alignment.TopStart),
            columns = GridCells.Fixed(15),
            content = {
                items(420){
                    Button(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .padding(1.dp),
                        onClick = {

                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                    ) {
                    }
                }
            }
        )

        Row(
            modifier = Modifier
                .offset(y = (-60).dp)
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(80.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .width(50.dp)
                .background(Color.Yellow)
                .clickable {  }
            )
            Box(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .width(50.dp)
                .background(Color.Red)
                .clickable {  }
            )
            Box(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .width(50.dp)
                .background(Color.Blue)
                .clickable {  }
            )
            Box(modifier = Modifier
                .padding(10.dp)
                .height(50.dp)
                .width(50.dp)
                .background(Color.Green)
                .clickable {  }
            )
        }
    }
}