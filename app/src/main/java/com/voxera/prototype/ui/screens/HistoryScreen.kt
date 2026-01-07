package com.voxera.prototype.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voxera.prototype.ui.components.VoxeraScaffold
import com.voxera.prototype.ui.components.defaultBottomItems
import com.voxera.prototype.ui.i18n.LocalStrings
import com.voxera.prototype.ui.navigation.Routes
import androidx.compose.material3.ExperimentalMaterial3Api


data class HistoryItem(val date: String, val action: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    onBack: () -> Unit,
    onOpenSettings: () -> Unit,
) {
    val s = LocalStrings.current
    val items = listOf(
        HistoryItem("29/12/2025", s.recordedVoice),
        HistoryItem("27/12/2025", s.recordedVoice),
        HistoryItem("25/12/2025", s.uploadedAudio),
        HistoryItem("24/12/2025", s.uploadedAudio),
        HistoryItem("21/12/2025", s.recordedVoice),
        HistoryItem("18/12/2025", s.recordedVoice),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s.analysisHistoryTitle) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = onOpenSettings) {
                        Icon(Icons.Filled.Settings, contentDescription = s.settings)
                    }
                }
            )
        },
        bottomBar = {
            // Keep the same bottom bar as in sketches; highlight none (history isn't in bottom bar).
            NavigationBar {
                defaultBottomItems().forEach { item ->
                    NavigationBarItem(
                        selected = false,
                        onClick = { /* user returns to main screens */ },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items) { hi ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
                ) {
                    Text(
                        text = "${hi.date} - ${hi.action}",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}
