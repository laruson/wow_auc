package andrey.chernikovich.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "realms")
data class RealmDb(
        @PrimaryKey
        val id: String,
        val name: String,
        val slug: String) : DbEntity