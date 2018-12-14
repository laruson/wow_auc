package andrey.chernikovich.domain.entity.pet

import andrey.chernikovich.domain.entity.DomainEntity

data class PetStats(
        val speciesId: Int,
        val breedId: Int,
        val petQualityId: Int,
        val level: Int,
        val health: Int,
        val power: Int,
        val speed: Int
) : DomainEntity
