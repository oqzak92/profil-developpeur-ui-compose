package com.example.profildeveloppeur.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

// Thème clair aux couleurs de Qoul
private val LightColorScheme = lightColorScheme(
    primary = QoulVert,
    onPrimary = QoulBlanc,
    primaryContainer = QoulVertClair,
    onPrimaryContainer = QoulVertFonce,
    secondary = QoulVertFonce,
    onSecondary = QoulBlanc,
    secondaryContainer = QoulVertClair,
    onSecondaryContainer = QoulVertFonce,
    error = QoulRouge,
    errorContainer = QoulRougeClair,
    onErrorContainer = QoulRouge,
    background = QoulGrisFond,
    onBackground = QoulNoir,
    surface = QoulBlanc,
    onSurface = QoulNoir,
    surfaceVariant = QoulGrisFond,
    onSurfaceVariant = QoulGrisTexte,
    outline = QoulGrisBord
)

// Thème sombre aux couleurs de Qoul
private val DarkColorScheme = darkColorScheme(
    primary = QoulVert,
    onPrimary = QoulNoir,
    primaryContainer = QoulVertSombre,
    onPrimaryContainer = QoulVert,
    secondary = QoulVert,
    onSecondary = QoulNoir,
    secondaryContainer = QoulVertSombre,
    onSecondaryContainer = QoulVertClair,
    error = QoulRouge,
    errorContainer = QoulRougeSombre,
    onErrorContainer = QoulRougeClair,
    background = QoulNoirFond,
    onBackground = QoulBlanc,
    surface = QoulGrisCarte,
    onSurface = QoulBlanc,
    surfaceVariant = QoulGrisCarteClair,
    onSurfaceVariant = QoulGrisTexteSombre,
    outline = QoulGrisBordSombre
)

@Composable
fun ProfilDeveloppeurTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    // Pas de couleurs dynamiques (Android 12+) : on garde toujours l'identité Qoul
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
