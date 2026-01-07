package com.voxera.prototype.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.voxera.prototype.ui.i18n.Language
import com.voxera.prototype.ui.screens.*

@Composable
fun AppNavHost(
    navController: NavHostController,
    language: Language,
    onLanguageChange: (Language) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                selectedRoute = Routes.HOME,
                onNavigate = { navController.navigate(it) { launchSingleTop = true } },
                onOpenHistory = { navController.navigate(Routes.HISTORY) },
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
            )
        }
        composable(Routes.PROFILE) {
            ProfileScreen(
                selectedRoute = Routes.PROFILE,
                onNavigate = { navController.navigate(it) { launchSingleTop = true } },
                onOpenHistory = { navController.navigate(Routes.HISTORY) },
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
            )
        }
        composable(Routes.ABOUT) {
            AboutScreen(
                selectedRoute = Routes.ABOUT,
                onNavigate = { navController.navigate(it) { launchSingleTop = true } },
                onOpenHistory = { navController.navigate(Routes.HISTORY) },
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
            )
        }
        composable(Routes.HISTORY) {
            HistoryScreen(
                onBack = { navController.popBackStack() },
                onOpenSettings = { navController.navigate(Routes.SETTINGS) },
            )
        }
        composable(Routes.SETTINGS) {
            SettingsScreen(
                language = language,
                onLanguageChange = onLanguageChange,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
