import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

actual class FighterDatabaseProvider {

    actual fun get(): FighterDatabase {
        return Room.databaseBuilder<FighterDatabase>(
            name = NSHomeDirectory() + "/fighter.db",
            factory = { FighterDatabase::class.instantiateImpl() }
        )
            .setDriver(BundledSQLiteDriver())
            .build()
    }
}