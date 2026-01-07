package com.voxera.prototype.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voxera.prototype.ui.i18n.Language
import com.voxera.prototype.ui.i18n.LocalStrings
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    language: Language,
    onLanguageChange: (Language) -> Unit,
    onBack: () -> Unit,
) {
    val s = LocalStrings.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s.settings) },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(s.language, style = MaterialTheme.typography.titleMedium)

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(
                    selected = language == Language.EN,
                    onClick = { onLanguageChange(Language.EN) },
                    label = { Text(s.english) }
                )
                FilterChip(
                    selected = language == Language.RU,
                    onClick = { onLanguageChange(Language.RU) },
                    label = { Text(s.russian) }
                )
            }
        }
    }
}
