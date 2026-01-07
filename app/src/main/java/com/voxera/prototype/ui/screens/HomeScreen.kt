package com.voxera.prototype.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.voxera.prototype.ui.components.VoxeraScaffold
import com.voxera.prototype.ui.components.defaultBottomItems
import com.voxera.prototype.ui.i18n.LocalStrings
import com.voxera.prototype.ui.i18n.Mode
import androidx.compose.runtime.saveable.rememberSaveable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    selectedRoute: String,
    onNavigate: (String) -> Unit,
    onOpenHistory: () -> Unit,
    onOpenSettings: () -> Unit,
) {
    val s = LocalStrings.current
    var mode by rememberSaveable { mutableStateOf(Mode.CLASSIC) }
    var expanded by remember { mutableStateOf(false) }

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
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(10.dp))

            // Mode dropdown (pink capsule-like look via filled tonal + rounded)
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                val label = when (mode) {
                    Mode.CLASSIC -> s.modeClassic
                    Mode.KIDS -> s.modeKids
                    Mode.BUSINESS -> s.modeBusiness
                    Mode.SPORT -> s.modeSport
                }

                TextField(
                    value = label,
                    onValueChange = {},
                    readOnly = true,
                    singleLine = true,
                    modifier = Modifier
                        .menuAnchor()
                        .widthIn(min = 190.dp),
                    shape = RoundedCornerShape(999.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        unfocusedContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        disabledContainerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        focusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent,
                        unfocusedIndicatorColor = androidx.compose.ui.graphics.Color.Transparent
                    ),
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) }
                )

                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    DropdownMenuItem(text = { Text(s.modeClassic) }, onClick = { mode = Mode.CLASSIC; expanded = false })
                    DropdownMenuItem(text = { Text(s.modeKids) }, onClick = { mode = Mode.KIDS; expanded = false })
                    DropdownMenuItem(text = { Text(s.modeBusiness) }, onClick = { mode = Mode.BUSINESS; expanded = false })
                    DropdownMenuItem(text = { Text(s.modeSport) }, onClick = { mode = Mode.SPORT; expanded = false })
                }
            }

            Spacer(Modifier.height(70.dp))
            Text(s.tapToRecord, style = MaterialTheme.typography.titleLarge)

            Spacer(Modifier.height(30.dp))

            // Big "V" in circle as record button placeholder
            OutlinedButton(
                onClick = { /* stub */ },
                shape = CircleShape,
                border = BorderStroke(3.dp, MaterialTheme.colorScheme.onSurface),
                modifier = Modifier.size(240.dp),
                contentPadding = PaddingValues(0.dp)
            ) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(
                        text = "V",
                        fontSize = 120.sp,
                        fontWeight = FontWeight.Black
                    )
                }
            }
        }
    }
}
