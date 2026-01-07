package com.voxera.prototype.ui

import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.rememberNavController
import com.voxera.prototype.ui.i18n.Language
import com.voxera.prototype.ui.i18n.LocalStrings
import com.voxera.prototype.ui.i18n.Strings
import com.voxera.prototype.ui.navigation.AppNavHost
import com.voxera.prototype.ui.theme.VoxeraTheme

@Composable
fun AppRoot() {
    var language by rememberSaveable { mutableStateOf(Language.EN) }

    CompositionLocalProvider(LocalStrings provides Strings.forLanguage(language)) {
        VoxeraTheme {
            val navController = rememberNavController()
            AppNavHost(
                navController = navController,
                language = language,
                onLanguageChange = { language = it }
            )
        }
    }
}
