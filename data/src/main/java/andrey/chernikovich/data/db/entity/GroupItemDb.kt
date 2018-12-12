package andrey.chernikovich.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "groupItems")
data class GroupItemDb(
        @PrimaryKey
        val id: String,
        val name: String,
        val icon: String,
        val itemClass: String,
        val itemSubClass: String,
        val itemLevel: String,
        val quality: String,
        val requiredLevel: String):DbEntity