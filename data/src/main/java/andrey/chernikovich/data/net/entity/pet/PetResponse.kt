package andrey.chernikovich.data.net.entity.pet

import andrey.chernikovich.data.net.entity.NetEntity
import andrey.chernikovich.domain.entity.pet.PetStats

data class PetResponse (
        val canBattle: Boolean,
        val creatureId: Int,
        val name: String,
        val family: String,
        val icon: String,
        val qualityId: Int,
        val stats: PetStats,
        val strongAgainst: List<String>,
        val typedId:Int,
        val weakAgainst: List<String>
):NetEntity