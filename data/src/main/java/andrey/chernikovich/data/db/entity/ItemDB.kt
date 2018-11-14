package andrey.chernikovich.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "items")
data class ItemDB(
        @PrimaryKey
        val id: Int,
        val name: String,
        val icon: String =""):DbEntity