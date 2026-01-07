VoxeraPrototype — clickable UI prototype (Jetpack Compose)

Open:
1) Unzip to a short path (e.g., C:\Projects\VoxeraPrototype or ~/Projects/VoxeraPrototype)
2) Android Studio -> File -> Open... -> select the folder containing settings.gradle.kts
3) Wait for Gradle sync.
4) Run on emulator (Tools -> Device Manager) or on a real device.

What is implemented:
- Bottom navigation: Home / Profile / About
- Top actions (Home/Profile/About): History (document icon) + Settings (gear icon)
- Home: mode dropdown (Classic/Kids/Business/Sport) + "Tap to record" + large V button
- Profile: user info + two clickable links (stubs)
- About: scrollable text + logo placeholder
- History: list of sessions (stub data)
- Settings: language switch EN/RU (English default)

Where to edit:
- Screens: app/src/main/java/com/voxera/prototype/ui/screens/
- Navigation: app/src/main/java/com/voxera/prototype/ui/navigation/
- Strings: app/src/main/java/com/voxera/prototype/ui/i18n/Strings.kt
