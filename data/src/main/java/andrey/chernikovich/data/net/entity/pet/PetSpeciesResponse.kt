package andrey.chernikovich.data.net.entity.pet

import andrey.chernikovich.data.net.entity.NetEntity
import andrey.chernikovich.domain.entity.pet.PetAbility

data class PetSpeciesResponse(
        val speciesId: String,
        val petTypeId: Int,
        val creatureId: Int,
        val name: String,
        val canBattle: Boolean,
        val icon: String,
        val description: String,
        val petAbility: List<PetAbility>
) :NetEntity