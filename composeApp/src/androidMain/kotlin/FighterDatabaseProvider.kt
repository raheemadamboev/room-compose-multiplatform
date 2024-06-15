import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

actual class FighterDatabaseProvider(
    private val context: Context
) {

    actual fun get(): FighterDatabase {
        return Room.databaseBuilder<FighterDatabase>(
            context = context,
            name = context.getDatabasePath("fighter.db").absolutePath
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}