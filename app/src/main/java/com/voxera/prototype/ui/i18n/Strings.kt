package com.voxera.prototype.ui.i18n

import androidx.compose.runtime.staticCompositionLocalOf

enum class Language { EN, RU }

enum class Mode { CLASSIC, KIDS, BUSINESS, SPORT }

data class AppStrings(
    val home: String,
    val profile: String,
    val about: String,
    val history: String,
    val settings: String,

    val tapToRecord: String,
    val modeClassic: String,
    val modeKids: String,
    val modeBusiness: String,
    val modeSport: String,

    val analysisHistoryTitle: String,
    val uploadedAudio: String,
    val recordedVoice: String,

    val uploadAudioFile: String,
    val upgradeToPro: String,

    val aboutTitle: String,

    val language: String,
    val english: String,
    val russian: String,
)

object Strings {
    fun forLanguage(lang: Language): AppStrings = when (lang) {
        Language.EN -> AppStrings(
            home = "Home",
            profile = "Profile",
            about = "About us",
            history = "History",
            settings = "Settings",

            tapToRecord = "Tap to record",
            modeClassic = "Classic",
            modeKids = "Kids (3+)",
            modeBusiness = "Business",
            modeSport = "Sport",

            analysisHistoryTitle = "Analysis history",
            uploadedAudio = "uploaded audio",
            recordedVoice = "recorded voice",

            uploadAudioFile = "Upload audio file",
            upgradeToPro = "Upgrade to Pro version — **$",

            aboutTitle = "Voxera",

            language = "Language",
            english = "English",
            russian = "Russian",
        )
        Language.RU -> AppStrings(
            home = "Главная",
            profile = "Профиль",
            about = "О нас",
            history = "История",
            settings = "Настройки",

            tapToRecord = "Нажми, чтобы записать",
            modeClassic = "Классический",
            modeKids = "Детский (от 3-х лет)",
            modeBusiness = "Бизнес",
            modeSport = "Спорт",

            analysisHistoryTitle = "История анализов",
            uploadedAudio = "загружен аудио-файл",
            recordedVoice = "записан голос",

            uploadAudioFile = "Загрузить аудио файл",
            upgradeToPro = "Перейти на Pro версию — **$",

            aboutTitle = "Voxera",

            language = "Язык",
            english = "Английский",
            russian = "Русский",
        )
    }
}

val LocalStrings = staticCompositionLocalOf<AppStrings> {
    error("Strings not provided")
}
