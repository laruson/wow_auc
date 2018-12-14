package andrey.chernikovich.domain.entity.pet

import andrey.chernikovich.domain.entity.DomainEntity

data class Pet(
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
) : DomainEntity