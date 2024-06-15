import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    dao: FighterDao
) {
    MaterialTheme {
        val scope = rememberCoroutineScope()
        val fighters by dao.getFighters().collectAsState(initial = emptyList())

        LaunchedEffect(
            key1 = Unit,
            block = {
                dao.insertFighter(FighterEntity("Conor McGregor"))
                dao.insertFighter(FighterEntity("Khabib Nurmagedov"))
                dao.insertFighter(FighterEntity("Jon Jones"))
                dao.insertFighter(FighterEntity("Alex Pereira"))
                dao.insertFighter(FighterEntity("Raheem Adam"))
            }
        )

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(
                items = fighters,
                key = { it.id }
            ) { fighter ->
                Text(
                    text = fighter.fullName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            scope.launch {
                                dao.deleteFighter(fighter)
                            }
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}