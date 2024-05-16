package com.peter.loginreg

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simple_listview.SimplelistActivity
import com.peter.loginreg.ui.theme.CalcActivity
import com.peter.loginreg.ui.theme.LoginregTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginregTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    Login()
                }
            }
        }
    }
}

@Composable
fun Login() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val context= LocalContext.current
    
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top, modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(
                Color.White
            )) {
        Text(
            text = "eMobilis",
            color = Color.Blue,
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive
        )
        Icon(imageVector = Icons.Default.Person, contentDescription = "person")
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            leadingIcon = {Icon(
                imageVector = Icons.Default.Email, contentDescription = "email")},
            label = { Text(text = "Email Address")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions()
        )
        OutlinedTextField(value = password, onValueChange = {password = it},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock,contentDescription = "password")},
            label = { Text(text = "Enter Password")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions()
            )
        Button(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()) {
            
            Text(text = "Login", fontSize = 22.sp)
          
        }
        Button(onClick = { val intent=Intent(context,RegisterActivity::class.java)
                         context.startActivity(intent)},
            modifier = Modifier.fillMaxWidth()) {

            Text(text = "Click to register", fontSize = 22.sp)

        }
        Button(onClick = { val intent=Intent(context,IntentActivity::class.java)
            context.startActivity(intent)},
            modifier = Modifier.fillMaxWidth()) {

            Text(text = "Intents", fontSize = 22.sp)
        }
        Button(onClick = { val intent=Intent(context,CalcActivity::class.java)
            context.startActivity(intent)},
            modifier = Modifier.fillMaxWidth()) {

            Text(text = "calculator", fontSize = 22.sp)
        }
        Button(onClick = { val intent=Intent(context,CustomActivity::class.java)
            context.startActivity(intent)},
            modifier = Modifier.fillMaxWidth()) {

            Text(text = "Custom list", fontSize = 22.sp)
        }
        Button(onClick = { val intent=Intent(context,SimplelistActivity::class.java)
            context.startActivity(intent)},
            modifier = Modifier.fillMaxWidth()) {

            Text(text = "lazycolumn", fontSize = 22.sp)
        }
        Button(onClick = { val intent=Intent(context,CardActivity::class.java)
            context.startActivity(intent)},
            modifier = Modifier.fillMaxWidth()) {

            Text(text = "Cardbox", fontSize = 22.sp)
        }


    }
}


@Preview
@Composable
private fun Loginprev() {
    Login()
}