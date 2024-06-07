package com.dadadadev.login_ui.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000113)
val LightBlueWhite = Color(0xFFBFDBFE)
val SocialMediaColor = Color(0xFFF1F5F9)
val BlueGray = Color(0xFF334155)

val ColorScheme.focusedTextField
    @Composable
    get() = if (isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.unfocusedTextField
    @Composable
    get() = if (isSystemInDarkTheme()) Color (0xFF94A3B8) else Color(0xFF475569)

val ColorScheme.textFieldContainer
    @Composable
    get() = if (isSystemInDarkTheme()) BlueGray.copy(alpha = 0.6f) else LightBlueWhite