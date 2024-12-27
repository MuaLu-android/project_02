package com.example.project_02

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_02.ui.theme.Project_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project_02Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { paddingValues ->
                    GreetingFontApp(paddingValues)
                }
            }
        }
    }
}
@Composable
private fun GreetingNameApp(){
    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier.weight(.6f)
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .background(Color(0x000000))
            )
            Text(
                text = "LAU A LU",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Android Deverloper Extrardinaire",
                textAlign = TextAlign.Center,
                color = Color(0xFF3ddc84),
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Column (
            modifier = Modifier.weight(.3f)
                .fillMaxWidth()
                .padding(16.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            GreetingIcon(
                incon = painterResource(R.drawable.baseline_local_phone_24),
                title = "+84 (0) 355 761 327"
            )
            GreetingIcon(
                incon = painterResource(R.drawable.baseline_share_24),
                title = "Ha Noi"
            )
            GreetingIcon(
                incon = painterResource(R.drawable.baseline_email_24),
                title = "laualu2k3@gmail.com"
            )
        }
    }
}
@Composable
private fun GreetingIcon(incon: Painter, title: String, modifier: Modifier = Modifier){
    Row (
        modifier = modifier
            .padding(bottom = 8.dp)){
        Image(
            painter = incon,
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}
@Composable
fun GreetingFontApp(paddingValues: PaddingValues){
    Column (Modifier.fillMaxWidth()){
        Row(modifier = Modifier.weight(1f)) {
            GreetingFont(
                title = stringResource(R.string.text_composable),
                descripton = "Displays text and follows the recommended Material Design guidelines.",
                backgroup = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            GreetingFont(
                title = stringResource(R.string.image_composable),
                descripton = "Creates a composable that lays out and draws a given Painter class object.",
                backgroup = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            GreetingFont(
                title = stringResource(R.string.row_composable),
                descripton = "A layout composable that places its children in a horizontal sequence.",
                backgroup = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            GreetingFont(
                title = stringResource(R.string.column_composable),
                descripton = "A layout composable that places its children in a vertical sequence.",
                backgroup = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}
@Composable
private fun GreetingFont(title: String,
                 descripton: String,
                 backgroup: Color,
                 modifier: Modifier = Modifier){
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(backgroup)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text(
                text = descripton,
                fontSize = 20.sp,
                textAlign = TextAlign.Justify
            )
        }
}
@Composable
fun GreetingEnd(paddingValues: PaddingValues){
    val image = painterResource(R.drawable.ic_task_completed)
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = image,
                contentDescription = null,

            )
            Text(
                text = stringResource(R.string.all_tasks_completed),
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.nice_work),
                fontSize = 16.sp
            )
        }
}
@Composable
fun GreetingListApp(paddingValues: PaddingValues){
    GreetingList(
        title = stringResource(R.string.jetpack_compose),
        message = stringResource(R.string.what_jetpack_compose),
        body = stringResource(R.string.in_this_tutorial),
        image = painterResource(R.drawable.bg_compose_background)
    )
}
@Composable
private fun GreetingList(title: String,
                         message: String,
                         body: String,
                         image: Painter,
                         modifier: Modifier = Modifier.fillMaxSize()){
    Column (
        modifier = modifier
    ){
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = message,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = body,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.androidparty)
    Box (modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            text = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }

}
@Composable
fun GreetingText(text: String, from: String, modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = text,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Project_02Theme {
        GreetingNameApp()
    }
}