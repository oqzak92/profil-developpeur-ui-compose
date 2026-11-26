package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.profildeveloppeur.data.profilZakariya
import com.example.profildeveloppeur.ui.EcranProfil
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    EcranProfil(
                        profil = profilZakariya,
                        onContactClick = {
                            // pas de vraie action pour l'instant (plus tard : ouvrir un email)
                        },
                        onPortfolioClick = {
                            // pas de vraie action pour l'instant (plus tard : ouvrir le site)
                        },
                        // innerPadding passé à la LazyColumn : le contenu défile sous les barres système
                        contentPadding = innerPadding
                    )
                }
            }
        }
    }
}
