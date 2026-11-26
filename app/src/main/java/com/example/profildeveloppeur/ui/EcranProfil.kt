package com.example.profildeveloppeur.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.data.Profil
import com.example.profildeveloppeur.data.profilSarah
import com.example.profildeveloppeur.data.profilZakariya
import com.example.profildeveloppeur.ui.components.EnTeteProfil
import com.example.profildeveloppeur.ui.components.ProjectCard
import com.example.profildeveloppeur.ui.components.SkillCard
import com.example.profildeveloppeur.ui.components.TitreSection
import com.example.profildeveloppeur.ui.components.ZoneContact
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

// Écran principal : tout l'écran est une LazyColumn (défilement vertical),
// les compétences sont une LazyRow (défilement horizontal) à l'intérieur.
@Composable
fun EcranProfil(
    profil: Profil,
    onContactClick: () -> Unit,
    onPortfolioClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    // Surface = fond de l'écran qui suit le thème (clair / sombre)
    Surface(modifier = modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        LazyColumn(
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = contentPadding.calculateTopPadding() + 16.dp,
                bottom = contentPadding.calculateBottomPadding() + 24.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { EnTeteProfil(profil = profil) }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                TitreSection(titre = "Compétences", icone = Icons.Filled.Build)
            }
            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    items(profil.competences, key = { it.nom }) { competence ->
                        SkillCard(competence = competence)
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                TitreSection(titre = "Projets & expériences", icone = Icons.Filled.Star)
            }
            items(profil.projets, key = { it.titre }) { projet ->
                ProjectCard(projet = projet)
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
                TitreSection(titre = "Contact", icone = Icons.Filled.Email)
            }
            item {
                ZoneContact(
                    profil = profil,
                    onContactClick = onContactClick,
                    onPortfolioClick = onPortfolioClick
                )
            }
        }
    }
}

// ---------- Previews de l'écran ----------

@Preview(name = "Écran - clair", showBackground = true, widthDp = 380, heightDp = 1500)
@Composable
fun PreviewEcranClair() {
    ProfilDeveloppeurTheme(darkTheme = false) {
        EcranProfil(profil = profilZakariya, onContactClick = {}, onPortfolioClick = {})
    }
}

@Preview(
    name = "Écran - sombre",
    showBackground = true,
    widthDp = 380,
    heightDp = 1500,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PreviewEcranSombre() {
    ProfilDeveloppeurTheme(darkTheme = true) {
        EcranProfil(profil = profilZakariya, onContactClick = {}, onPortfolioClick = {})
    }
}

@Preview(name = "Autre profil - indisponible", showBackground = true, widthDp = 380, heightDp = 1000)
@Composable
fun PreviewEcranAutreProfil() {
    ProfilDeveloppeurTheme {
        EcranProfil(profil = profilSarah, onContactClick = {}, onPortfolioClick = {})
    }
}
