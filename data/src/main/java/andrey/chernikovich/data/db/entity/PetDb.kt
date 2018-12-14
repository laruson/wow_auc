package andrey.chernikovich.data.db.entity

import andrey.chernikovich.domain.entity.pet.PetStats
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "pets")
data class PetDb (
        val canBattle: Boolean,
        @PrimaryKey
        val creatureId: Int,
        val name: String,
        val family: String,
        val icon: String,
        val qualityId: Int,
        val stats: PetStats,
        val strongAgainst: List<String>,
        val typedId:Int,
        val weakAgainst: List<String>
):DbEntity