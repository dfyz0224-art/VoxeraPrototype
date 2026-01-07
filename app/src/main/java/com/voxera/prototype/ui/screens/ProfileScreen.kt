package com.voxera.prototype.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.voxera.prototype.ui.components.VoxeraScaffold
import com.voxera.prototype.ui.components.defaultBottomItems
import com.voxera.prototype.ui.i18n.LocalStrings

@Composable
fun ProfileScreen(
    selectedRoute: String,
    onNavigate: (String) -> Unit,
    onOpenHistory: () -> Unit,
    onOpenSettings: () -> Unit,
) {
    val s = LocalStrings.current
    VoxeraScaffold(
        title = null,
        selectedRoute = selectedRoute,
        bottomItems = defaultBottomItems(),
        onBottomNavigate = onNavigate,
        onOpenHistory = onOpenHistory,
        onOpenSettings = onOpenSettings
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("Ivan E.", style = MaterialTheme.typography.titleLarge)
            Text("Email: ***@gmail.com", style = MaterialTheme.typography.bodyLarge)
            Text("Phone number: +7*******", style = MaterialTheme.typography.bodyLarge)

            Spacer(Modifier.height(40.dp))

            val linkStyle = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                textDecoration = TextDecoration.Underline
            )
            Text(
                s.uploadAudioFile,
                style = linkStyle,
                modifier = Modifier.clickable { /* stub */ }
            )
            Text(
                s.upgradeToPro,
                style = linkStyle,
                modifier = Modifier.clickable { /* stub */ }
            )
        }
    }
}
