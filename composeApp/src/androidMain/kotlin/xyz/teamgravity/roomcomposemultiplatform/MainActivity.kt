package xyz.teamgravity.roomcomposemultiplatform

import App
import FighterDatabaseProvider
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val dao = FighterDatabaseProvider(applicationContext).get().fighterDao()

        setContent {
            App(
                dao = dao
            )
        }
    }
}