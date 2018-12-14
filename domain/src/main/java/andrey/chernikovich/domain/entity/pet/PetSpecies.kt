package andrey.chernikovich.domain.entity.pet

import andrey.chernikovich.domain.entity.DomainEntity

data class PetSpecies(
        val speciesId: String,
        val petTypeId: Int,
        val creatureId: Int,
        val name: String,
        val canBattle: Boolean,
        val icon: String,
        val description: String,
        val petAbility: List<PetAbility>
) : DomainEntity