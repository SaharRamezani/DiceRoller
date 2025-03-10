package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceRollerTheme {
                DiceRoller(modifier = Modifier.fillMaxSize().wrapContentSize(align = Alignment.Center))
            }
        }
    }
}

@Composable
fun DiceRoller(modifier: Modifier = Modifier) {
    Column {
        var id = remember by { mutableStateOf(1) }
        val imageLink = when(id) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        Column(modifier = modifier/*, horizontalAlignment = Alignment.CenterHorizontally*/) {
            Image(painterResource(imageLink)/*, contentDescription = result.toString()*/)
            /*Button(
                onClick = { result = (1..6).random() },
            ) {
                Text(text = stringResource(R.string.roll), fontSize = 24.sp)
            }*/
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerPreview() {
    DiceRollerTheme {
        DiceRoller()
    }
}