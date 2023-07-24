package com.example.radiobutton

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier

@Composable
fun RadioButtonScreen() {

    /*var radioState by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(),
    contentAlignment = Alignment.Center){
        RadioButton(selected = radioState,
            onClick = {
                radioState = !radioState
            })
    }*/

    val gender = listOf("Male","Female","Other")
    var genderState by remember {
        mutableStateOf("Male")
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            gender.forEach{
                RadioEachRow(selected = genderState==it, title = it){data->
                    genderState=data
                }
            }
        }
    }
}

@Composable
fun RadioEachRow(
    selected:Boolean,
    title:String,
    onValueChange:(String)->Unit
) {
    Row {
        RadioButton(selected = selected,
            onClick = {
                onValueChange(title)
            })
        Text(text = title,
            modifier = Modifier.align(CenterVertically))
    }

}