package com.voxera.prototype.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.voxera.prototype.ui.components.VoxeraScaffold
import com.voxera.prototype.ui.components.defaultBottomItems
import com.voxera.prototype.ui.i18n.LocalStrings
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun AboutScreen(
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
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Simple logo placeholder
            Surface(
                tonalElevation = 4.dp,
                shape = RoundedCornerShape(16.dp),
            ) {
                Box(Modifier.fillMaxWidth().padding(18.dp)) {
                    Text("VOXERA", style = MaterialTheme.typography.headlineMedium)
                }
            }

            Text(
                text = "Voxera — это модульная экосистема голосового искусственного интеллекта, " +
                        "разработанная для многомерной оценки психофизиологического и поведенческого состояния " +
                        "человека на основе коротких голосовых сессий (15–30 секунд). Платформа объединяет " +
                        "цифровую обработку сигналов, машинное обучение и сценарно-ориентированную интерпретацию, " +
                        "что позволяет анализировать эмоциональное состояние, стресс, когнитивную нагрузку и другие " +
                        "параметры через голосовые биомаркеры."
            )
        }
    }
}
