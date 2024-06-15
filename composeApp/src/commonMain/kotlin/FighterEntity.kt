import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("table_fighter")
data class FighterEntity(
    @ColumnInfo("full_name") val fullName: String,
    @PrimaryKey(autoGenerate = true) @ColumnInfo("id") val id: Long = 0
)
