package com.voxera.prototype.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.voxera.prototype.ui.i18n.LocalStrings
import androidx.compose.material3.ExperimentalMaterial3Api


data class BottomItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoxeraScaffold(
    title: String? = null,
    showTopActions: Boolean = true,
    selectedRoute: String,
    bottomItems: List<BottomItem>,
    onBottomNavigate: (String) -> Unit,
    onOpenHistory: () -> Unit,
    onOpenSettings: () -> Unit,
    content: @Composable (padding: androidx.compose.foundation.layout.PaddingValues) -> Unit
) {
    val s = LocalStrings.current
    Scaffold(
        topBar = {
            if (showTopActions) {
                TopAppBar(
                    title = { if (title != null) Text(title) else Text("") },
                    navigationIcon = {
                        IconButton(onClick = onOpenHistory) {
                            Icon(Icons.Filled.Description, contentDescription = s.history)
                        }
                    },
                    actions = {
                        IconButton(onClick = onOpenSettings) {
                            Icon(Icons.Filled.Settings, contentDescription = s.settings)
                        }
                    }
                )
            }
        },
        bottomBar = {
            NavigationBar {
                bottomItems.forEach { item ->
                    NavigationBarItem(
                        selected = selectedRoute == item.route,
                        onClick = { onBottomNavigate(item.route) },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        },
        content = content
    )
}

@Composable
fun defaultBottomItems(): List<BottomItem> {
    val s = LocalStrings.current
    return listOf(
        BottomItem(route = "home", label = s.home, icon = Icons.Filled.Home),
        BottomItem(route = "profile", label = s.profile, icon = Icons.Filled.Person),
        BottomItem(route = "about", label = s.about, icon = Icons.Filled.Info),
    )
}
