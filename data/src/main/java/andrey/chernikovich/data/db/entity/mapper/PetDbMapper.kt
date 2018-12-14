package andrey.chernikovich.data.db.entity.mapper

import andrey.chernikovich.data.db.entity.PetDb
import andrey.chernikovich.domain.entity.pet.Pet


fun PetDb.transformToDomain(): Pet {
    return Pet(canBattle = canBattle,
            creatureId = creatureId,
            name = name,
            family = family,
            icon = icon,
            qualityId = qualityId,
            stats = stats,
            strongAgainst = strongAgainst,
            typedId = typedId,
            weakAgainst = weakAgainst)
}

fun Pet.transformToPetDb(): PetDb {
    return PetDb(canBattle = canBattle,
            creatureId = creatureId,
            name = name,
            family = family,
            icon = icon,
            qualityId = qualityId,
            stats = stats,
            strongAgainst = strongAgainst,
            typedId = typedId,
            weakAgainst = weakAgainst)
}