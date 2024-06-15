import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [
        FighterEntity::class
    ]
)
abstract class FighterDatabase : RoomDatabase() {

    abstract fun fighterDao(): FighterDao
}