package com.dadadadev.login_ui

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dadadadev.login_ui.ui.theme.Black
import com.dadadadev.login_ui.ui.theme.BlueGray
import com.dadadadev.login_ui.ui.theme.LightBlueWhite
import com.dadadadev.login_ui.ui.theme.Roboto
import com.dadadadev.login_ui.ui.theme.ScreenOrientation
import com.dadadadev.login_ui.ui.theme.dimens

@Preview
@Composable
fun LoginScreen() {
    Surface {
        if (ScreenOrientation == Configuration.ORIENTATION_PORTRAIT) {
            PortraitScreenOrientation()
        } else {
            LandscapeScreenOrientation()
        }
    }
}

@Composable
private fun LandscapeScreenOrientation() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 3.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center
    ) {
        LoginSection()
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))
        SocialMediaSection()

        Spacer(modifier = Modifier.weight(0.8f))
        CreateAccountSection()
        Spacer(modifier = Modifier.weight(0.2f))
    }
}

@Composable
private fun PortraitScreenOrientation() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        TopSection()
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium1))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            LoginSection()
            Spacer(modifier = Modifier.height(MaterialTheme.dimens.medium2))
            SocialMediaSection()
        }

        Spacer(modifier = Modifier.weight(0.8f))
        CreateAccountSection()
        Spacer(modifier = Modifier.weight(0.2f))
    }
}

@Composable
private fun ColumnScope.CreateAccountSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black

    Text(
        modifier = Modifier.align(Alignment.CenterHorizontally),
        text = buildAnnotatedString {
        withStyle(
            SpanStyle(
                color = Color(0xFF94A3B8),
                fontSize = MaterialTheme.typography.labelMedium.fontSize,
                fontFamily = Roboto,
                fontWeight = FontWeight.Normal
            )
        ) {
            append("Don't have account?")
        }

        withStyle(
            SpanStyle(
                color = uiColor,
                fontSize = MaterialTheme.typography.labelMedium.fontSize,
                fontFamily = Roboto,
                fontWeight = FontWeight.Medium
            )
        ) {
            append(" ")
            append("Create now")
        }
    })
}

@Composable
private fun SocialMediaSection() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Or continue with",
            style = MaterialTheme.typography.labelMedium.copy(color = Color(0xFF64748B))
        )
        Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SocialMediaLogIn(
                icon = R.drawable.google,
                text = "Google",
                modifier = Modifier.weight(1f)
            ) {}
            Spacer(modifier = Modifier.width(20.dp))
            SocialMediaLogIn(
                icon = R.drawable.facebook,
                text = "Facebook",
                modifier = Modifier.weight(1f)
            ) {}
        }
    }
}

@Composable
private fun LoginSection() {
    LoginTextField(trailing = "Forgot?", label = "Email", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small2))
    LoginTextField(trailing = "Forgot?", label = "Password", modifier = Modifier.fillMaxWidth())
    Spacer(modifier = Modifier.height(MaterialTheme.dimens.small3))
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(MaterialTheme.dimens.buttonHeight),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = if (isSystemInDarkTheme()) BlueGray else Black
        ),
        shape = RoundedCornerShape(size = 4.dp)
    ) {
        Text(
            text = "Log In",
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium)
        )
    }
}

@Composable
private fun TopSection() {
    val uiColor = if (isSystemInDarkTheme()) Color.White else Black
    val shapeColor = if (isSystemInDarkTheme()) BlueGray else LightBlueWhite
    val screenHeight = LocalConfiguration.current.screenHeightDp

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height((screenHeight / 2.12).dp),
            painter = painterResource(id = R.drawable.shape),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(shapeColor)
        )

        Row(
            modifier = Modifier.padding(top = MaterialTheme.dimens.large),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(MaterialTheme.dimens.logoSize),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                tint = uiColor
            )
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = stringResource(R.string.find_tolet),
                    style = MaterialTheme.typography.headlineMedium,
                    color = uiColor
                )
                Text(
                    text = stringResource(R.string.find_house),
                    style = MaterialTheme.typography.titleMedium,
                    color = uiColor
                )
            }
        }

        Text(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp),
            text = stringResource(R.string.login),
            style = MaterialTheme.typography.headlineLarge,
            color = uiColor
        )
    }
}