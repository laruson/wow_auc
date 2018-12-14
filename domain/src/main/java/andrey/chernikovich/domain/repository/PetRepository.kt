package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.pet.*
import io.reactivex.Flowable
import io.reactivex.Observable

interface PetRepository {
    fun getPetsRest(): Flowable<List<Pet>>

    fun getPetsDao():Flowable<List<Pet>>

    fun searchPet(searchPet: SearchPet): Flowable<List<Pet>>

    fun savePets(pet: Pet)

    fun getPetAbilityInfo(abilityId: Int): Observable<PetAbility>

    fun getPetSpecies(speciesId: Int): Observable<PetSpecies>
}