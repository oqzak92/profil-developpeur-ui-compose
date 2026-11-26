package com.example.profildeveloppeur.data

// Données locales écrites directement dans le code (pas d'API, pas de base de données)

data class Competence(
    val nom: String,
    val niveau: String
)

data class Projet(
    val titre: String,
    val description: String,
    val technologies: List<String>,
    val annee: String
)

data class Profil(
    val nom: String,
    val role: String,
    val description: String,
    val email: String,
    val ville: String,
    val disponibilite: String,
    val estDisponible: Boolean,
    val portfolio: String,
    val competences: List<Competence>,
    val projets: List<Projet>
)

val profilZakariya = Profil(
    nom = "Zakariya Belkassem",
    role = "Développeur Android & full-stack",
    description = "Étudiant en Master Ingénierie logicielle à l'ESGI Lyon, en alternance chez Ypok. " +
        "Je crée aussi Qoul, une application de commande pour les restaurants.",
    email = "contact@qoul.fr",
    ville = "Lyon, France",
    disponibilite = "En alternance chez Ypok",
    estDisponible = true,
    portfolio = "oqzak92.github.io/portfolioZak",
    competences = listOf(
        Competence("Kotlin", "Intermédiaire"),
        Competence("Compose", "Débutant"),
        Competence("Java / Spring", "Avancé"),
        Competence("React / Vue.js", "Avancé"),
        Competence("Python / Django", "Intermédiaire"),
        Competence("Docker & CI/CD", "Intermédiaire")
    ),
    projets = listOf(
        Projet(
            titre = "Qoul",
            description = "Application de commande en ligne pour les restaurants : carte, panier et suivi des commandes.",
            technologies = listOf("Vue.js", "Node.js", "PostgreSQL"),
            annee = "2025"
        ),
        Projet(
            titre = "Product Explorer",
            description = "Écran d'accueil Compose qui affiche un catalogue de produits avec un écran de détail.",
            technologies = listOf("Kotlin", "Compose"),
            annee = "2026"
        ),
        Projet(
            titre = "Quiz ESGI",
            description = "Application de quiz en temps réel réalisée en équipe pendant le Master.",
            technologies = listOf("React", "WebSocket"),
            annee = "2026"
        ),
        Projet(
            titre = "Alternance Ypok",
            description = "Développement de fonctionnalités web et maintenance d'applications métier.",
            technologies = listOf("Java", "Spring Boot"),
            annee = "2024 – aujourd'hui"
        )
    )
)

// Deuxième profil fictif, utilisé dans les previews
val profilSarah = Profil(
    nom = "Sarah Martin",
    role = "Développeuse full-stack freelance",
    description = "Je conçois des applications web et mobiles, du back-end jusqu'à l'interface.",
    email = "sarah@exemple.fr",
    ville = "Paris, France",
    disponibilite = "Pas disponible avant mars",
    estDisponible = false,
    portfolio = "sarah-dev.fr",
    competences = listOf(
        Competence("TypeScript", "Avancé"),
        Competence("React", "Avancé"),
        Competence("Node.js", "Intermédiaire")
    ),
    projets = listOf(
        Projet(
            titre = "Boutique en ligne",
            description = "Site e-commerce complet pour une marque de vêtements.",
            technologies = listOf("Next.js", "Stripe"),
            annee = "2025"
        )
    )
)
