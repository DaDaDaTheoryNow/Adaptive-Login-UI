package com.dadadadev.login_ui.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun AppUtils(
    dimens: Dimens,
    content: @Composable () -> Unit
) {
    val appDimens = remember {
        dimens
    }

    CompositionLocalProvider(LocalAppDimens provides appDimens) {
        content()
    }
}

val LocalAppDimens = compositionLocalOf {
    CompactDimens
}

val ScreenOrientation
    @Composable
    get() = LocalConfiguration.current.orientation