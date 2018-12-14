package andrey.chernikovich.data.net.entity.mapper

import andrey.chernikovich.data.db.entity.PetDb
import andrey.chernikovich.data.net.entity.pet.PetAbilityResponse
import andrey.chernikovich.data.net.entity.pet.PetListResponse
import andrey.chernikovich.data.net.entity.pet.PetResponse
import andrey.chernikovich.data.net.entity.pet.PetSpeciesResponse
import andrey.chernikovich.domain.entity.pet.Pet
import andrey.chernikovich.domain.entity.pet.PetAbility
import andrey.chernikovich.domain.entity.pet.PetList
import andrey.chernikovich.domain.entity.pet.PetSpecies

fun PetResponse.transformToPetDb(): PetDb {
    return PetDb(canBattle = canBattle,
            creatureId = creatureId,
            name = name,
            family = family,
            icon = "https://wow.zamimg.com/images/wow/icons/large/$icon.jpg",
            qualityId = qualityId,
            stats = stats,
            strongAgainst = strongAgainst,
            typedId = typedId,
            weakAgainst = weakAgainst)
}

fun PetResponse.transformToDomain(): Pet {
    return Pet(canBattle = canBattle,
            creatureId = creatureId,
            name = name,
            family = family,
            icon = "https://wow.zamimg.com/images/wow/icons/large/$icon.jpg",
            qualityId = qualityId,
            stats = stats,
            strongAgainst = strongAgainst,
            typedId = typedId,
            weakAgainst = weakAgainst)
}

fun PetAbilityResponse.transformToDomain(): PetAbility {
    return PetAbility(
            slot = slot,
            order = order,
            requiredLevel = requiredLevel,
            id = id,
            name = name,
            icon = "https://wow.zamimg.com/images/wow/icons/large/$icon.jpg",
            cooldown = cooldown,
            rounds = rounds,
            petTypeId = petTypeId,
            isPassive = isPassive,
            hideHints = hideHints)
}

fun PetSpeciesResponse.transformToDomain(): PetSpecies {
    return PetSpecies(
            speciesId = speciesId,
            petTypeId = petTypeId,
            creatureId = creatureId,
            name = name,
            canBattle = canBattle,
            icon = "https://wow.zamimg.com/images/wow/icons/large/$icon.jpg",
            description = description,
            petAbility = petAbility)
}

fun PetListResponse.transformToDomain():PetList{
    return PetList(pets.map {
        it.transformToDomain()
    })
}
