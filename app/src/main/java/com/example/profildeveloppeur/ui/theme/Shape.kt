package com.example.profildeveloppeur.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Coins arrondis utilisés partout via MaterialTheme.shapes
val Shapes = Shapes(
    small = RoundedCornerShape(8.dp),   // chips de technologies
    medium = RoundedCornerShape(12.dp), // cartes de compétences, badge
    large = RoundedCornerShape(20.dp)   // grandes cartes (en-tête, projets)
)
