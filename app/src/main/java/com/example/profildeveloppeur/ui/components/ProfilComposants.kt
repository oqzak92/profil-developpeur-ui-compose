package com.example.profildeveloppeur.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeur.R
import com.example.profildeveloppeur.data.Competence
import com.example.profildeveloppeur.data.Profil
import com.example.profildeveloppeur.data.Projet
import com.example.profildeveloppeur.data.profilZakariya
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

// ---------- En-tête ----------

// Box : l'avatar et le badge sont superposés (badge en bas à droite de l'image)
@Composable
fun AvatarAvecBadge(estDisponible: Boolean, modifier: Modifier = Modifier) {
    Box(modifier = modifier.size(96.dp)) {
        Image(
            painter = painterResource(R.drawable.avatar_placeholder),
            contentDescription = "Photo de profil",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(96.dp)
                .clip(CircleShape)
        )
        Surface(
            shape = CircleShape,
            color = if (estDisponible) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
            border = BorderStroke(3.dp, MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(28.dp)
        ) {
            Icon(
                imageVector = if (estDisponible) Icons.Filled.Check else Icons.Filled.Close,
                contentDescription = if (estDisponible) "Disponible" else "Indisponible",
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun EnTeteProfil(profil: Profil, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                AvatarAvecBadge(estDisponible = profil.estDisponible)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = profil.nom,
                        style = MaterialTheme.typography.headlineSmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = profil.role,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = profil.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(16.dp))
            BadgeDisponibilite(texte = profil.disponibilite, estDisponible = profil.estDisponible)
        }
    }
}

// Surface colorée selon le thème : vert si disponible, rouge sinon
@Composable
fun BadgeDisponibilite(texte: String, estDisponible: Boolean, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        color = if (estDisponible) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.errorContainer,
        contentColor = if (estDisponible) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onErrorContainer
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Icon(imageVector = Icons.Filled.Info, contentDescription = null, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = texte, style = MaterialTheme.typography.labelMedium)
        }
    }
}

// ---------- Sections ----------

@Composable
fun TitreSection(titre: String, icone: ImageVector, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Icon(imageVector = icone, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = titre,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

// Un élément de la LazyRow des compétences
@Composable
fun SkillCard(competence: Competence, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.width(150.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Icon(imageVector = Icons.Filled.Build, contentDescription = null, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = competence.nom,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(text = competence.niveau, style = MaterialTheme.typography.labelMedium)
        }
    }
}

// Petite pastille pour une techno dans une carte projet
@Composable
fun TechnologyChip(nom: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.surfaceVariant,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline)
    ) {
        Text(
            text = nom,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
        )
    }
}

// Un élément de la liste des projets (items de la LazyColumn)
@Composable
fun ProjectCard(projet: Projet, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = projet.titre,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = projet.annee,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = projet.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                projet.technologies.forEach { techno -> TechnologyChip(nom = techno) }
            }
        }
    }
}

// ---------- Contact ----------

// Champ en lecture seule : affiche une info structurée, on ne peut pas la modifier
@Composable
fun ChampInfo(label: String, valeur: String, icone: ImageVector, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = valeur,
        onValueChange = {},
        readOnly = true,
        label = { Text(label) },
        leadingIcon = { Icon(imageVector = icone, contentDescription = null) },
        singleLine = true,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun ZoneContact(
    profil: Profil,
    onContactClick: () -> Unit,
    onPortfolioClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ChampInfo(label = "Email", valeur = profil.email, icone = Icons.Filled.Email)
            ChampInfo(label = "Localisation", valeur = profil.ville, icone = Icons.Filled.Place)
            ChampInfo(label = "Portfolio", valeur = profil.portfolio, icone = Icons.Filled.Star)
            Spacer(modifier = Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedButton(onClick = onPortfolioClick, modifier = Modifier.weight(1f)) {
                    Text("Portfolio")
                }
                Button(onClick = onContactClick, modifier = Modifier.weight(1f)) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = null, modifier = Modifier.size(18.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Contacter")
                }
            }
        }
    }
}

// ---------- Previews des composants ----------

@Preview(name = "SkillCard", showBackground = true)
@Composable
fun PreviewSkillCard() {
    ProfilDeveloppeurTheme {
        SkillCard(competence = Competence("Kotlin", "Intermédiaire"), modifier = Modifier.padding(16.dp))
    }
}

@Preview(name = "ProjectCard", showBackground = true, widthDp = 360)
@Composable
fun PreviewProjectCard() {
    ProfilDeveloppeurTheme {
        ProjectCard(projet = profilZakariya.projets.first(), modifier = Modifier.padding(16.dp))
    }
}
